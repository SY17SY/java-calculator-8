package calculator.ui;

import static calculator.parser.InputParser.hasCustomPrefix;
import static calculator.parser.InputParser.hasCustomSuffix;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readExpression() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String first = Console.readLine();
        if (hasCustomPrefix(first) && !hasCustomSuffix(first)) {
            String second = Console.readLine();
            first = first + "\\n" + second;
        }
        return first;
    }
}
