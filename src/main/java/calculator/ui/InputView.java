package calculator.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readExpression() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String first = Console.readLine();
        if (first.contains("//") && !first.contains("\\n")) {
            String second = Console.readLine();
            first = first + "\\n" + second;
        }
        return first;
    }
}
