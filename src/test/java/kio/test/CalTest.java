package kio.test;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@DisplayName("Cal test")
public class CalTest {
    CalService calService;
    Calculator calculator;

    @BeforeEach
    @Tag("fast")
    void setUp() {
        calService = new CalService();
        calculator = new Calculator();
        calculator.setNumber1(10);
        calculator.setNumber2(2);
    }
    @BeforeAll
    static void beforeAll() {
        System.out.println("테스트 시작");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("🧹테스트 끝");
    }
    @Test
    @DisplayName("더하기")
    void testAdd() {
        int result = calService.add(calculator);
        assertEquals(12, result);
    }

    @Test
    @DisplayName("빼기")
    void testSubtract() {
        int result = calService.subtract(calculator);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("곱하기")
    void testMultiply() {
        int result = calService.multiply(calculator);
        assertEquals(20, result);
    }

    @Test
    @DisplayName("나누기")
    void testDivide() {
        int result = calService.divide(calculator);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("0으로 나누기 예외 테스트")
    void testDivideByZero() {
        calculator.setNumber2(0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calService.divide(calculator);
        });
        assertEquals("0으로 나눌 수 없습니다.", exception.getMessage());
    }
}
