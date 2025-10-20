package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class InputView {
    public String input() throws IOException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String first = Console.readLine();
        if (first.startsWith("//") && !first.contains("\\n")) {
            String second = Console.readLine();
            first = first + "\\n" + second;
        }
        return first;
    }
}
