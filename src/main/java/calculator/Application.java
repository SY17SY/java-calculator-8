package calculator;

import calculator.ui.InputView;
import calculator.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView in = new InputView();
        OutputView out = new OutputView();

        String input = in.readExpression();
        int result = StringCalculator.add(input);
        out.printResult(result);
    }
}
