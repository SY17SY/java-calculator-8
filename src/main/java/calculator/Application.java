package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.DelimiterGenerator;
import calculator.domain.NumberSeparator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DelimiterGenerator delimiterGenerator = new DelimiterGenerator();
        NumberSeparator numberSeparator = new NumberSeparator(delimiterGenerator);
        Calculator calculator = new Calculator(numberSeparator);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController controller = new CalculatorController(inputView, outputView, calculator);

        controller.runCalculator();
    }
}
