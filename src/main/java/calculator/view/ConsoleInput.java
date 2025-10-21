package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput {
    private static final String CUSTOM_PREFIX = "//";
    private static final String CUSTOM_SUFFIX = "\\n";

    public String input() {
        String first = Console.readLine();
        if (first.startsWith(CUSTOM_PREFIX) && !first.contains(CUSTOM_SUFFIX)) {
            String second = Console.readLine();
            first = first + CUSTOM_SUFFIX + second;
        }
        return first;
    }
}
