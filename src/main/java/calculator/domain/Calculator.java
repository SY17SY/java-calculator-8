package calculator.domain;

public class Calculator {
    private final NumberSeparator numberSeparator;

    public Calculator(NumberSeparator numberSeparator) {
        this.numberSeparator = numberSeparator;
    }

    public int add(String stringInputs) {
        int[] splitNum = numberSeparator.splitNum(stringInputs);
        int sum = 0;
        for (int num : splitNum) {
            sum += num;
        }
        return sum;
    }
}
