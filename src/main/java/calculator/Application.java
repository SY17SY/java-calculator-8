package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.contains("//") && !input.contains("\\n")) {
            String body = Console.readLine();
            input = input + "\\n" + body;
        }
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}
