package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.DelimiterParser;
import calculator.domain.NumberExtractor;
import calculator.view.ConsoleInput;
import calculator.view.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        DelimiterParser delimiterParser = new DelimiterParser();
        NumberExtractor numberExtractor = new NumberExtractor(delimiterParser);
        Calculator calculator = new Calculator(numberExtractor);

        ConsoleInput consoleInput = new ConsoleInput();
        ConsoleOutput consoleOutput = new ConsoleOutput();

        CalculatorController controller = new CalculatorController(consoleInput, consoleOutput, calculator);

        controller.runCalculator();
    }
}
