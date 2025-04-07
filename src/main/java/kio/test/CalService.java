package kio.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CalService {
    public int add(Calculator calculator) {
        return calculator.getNumber1() + calculator.getNumber2();
    }

    public int subtract(Calculator calculator) {
        return calculator.getNumber1() - calculator.getNumber2();
    }

    public int multiply(Calculator calculator) {
        return calculator.getNumber1() * calculator.getNumber2();
    }

    public int divide(Calculator calculator) {
        if (calculator.getNumber2() == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return calculator.getNumber1() / calculator.getNumber2();
    }
}
