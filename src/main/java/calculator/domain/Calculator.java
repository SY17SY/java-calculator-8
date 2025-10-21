package calculator.domain;

import java.util.List;

public class Calculator {
    private final NumberExtractor numberExtractor;

    public Calculator(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }

    public int add(String stringInput) {
        List<Integer> intInputs = numberExtractor.extract(stringInput);
        int sum = 0;
        for (int num : intInputs) {
            sum += num;
        }
        return sum;
    }
}
