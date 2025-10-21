package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.ConsoleInput;
import calculator.view.ConsoleOutput;

public class CalculatorController {
    private final ConsoleInput consoleInput;
    private final ConsoleOutput consoleOutput;
    private final Calculator calculator;

    public CalculatorController(ConsoleInput consoleInput, ConsoleOutput consoleOutput, Calculator calculator) {
        this.consoleInput = consoleInput;
        this.consoleOutput = consoleOutput;
        this.calculator = calculator;
    }

    public void runCalculator() {
//        String stringInputs = consoleInput.input();
//        int result = calculator.add(stringInputs);
//        consoleOutput.printResult(result);
    }
}
