package calculator.domain;

import java.util.List;

public class Calculator {
    private final NumberExtractor numberExtractor;

    public Calculator(NumberExtractor numberExtractor) {
        this.numberExtractor = numberExtractor;
    }

    public int add(String stringInput) {
        List<Integer> intInputs = numberExtractor.extract(stringInput);
        long longSum = 0;
        for (int num : intInputs) {
            longSum += num;
        }
        IntegerValidator.requireIntRange(longSum);
        return (int) longSum;
    }
}
