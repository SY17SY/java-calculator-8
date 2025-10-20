package calculator.parser;

import java.util.List;

public class InputParser {
    public static final String DEFAULT_DELIMITER = ",:";

    public static List<String> parse(String input) {
        validateCustomSyntax(input);
        Parsed parsed = setDelimiter(input);
        String delimiter = parsed.delimiter;
        String body = parsed.body;
        return List.of(body.split(delimiter));
    }

    private static void validateCustomSyntax(String input) {
        if (hasCustomPrefix(input) && !hasCustomSuffix(input)) {
            throw new IllegalArgumentException("커스텀 구분자 작성 형식이 올바르지 않습니다");
        }
    }

    private static Parsed setDelimiter(String input) {
        if (hasCustomPrefix(input) && hasCustomSuffix(input)) {
            int idx = input.indexOf("\\n");
            String delimiter = addCustomDelimiter(input, idx);
            String body = input.substring(idx + 2);
            return new Parsed(delimiter, body);
        }
        String defaultDelimiter = "[" + DEFAULT_DELIMITER + "]";
        return new Parsed(defaultDelimiter, input);
    }

    public static boolean hasCustomPrefix(String input) {
        return input.startsWith("//");
    }

    public static boolean hasCustomSuffix(String input) {
        return input.contains("\\n");
    }

    private static String addCustomDelimiter(String input, int idx) {
        String customDelimiter = input.substring(2, idx);
        validateCustomEmpty(customDelimiter);
        String delimiter = DEFAULT_DELIMITER + customDelimiter;
        return "[" + delimiter + "]";
    }

    private static void validateCustomEmpty(String custom) {
        if (custom.isEmpty()) {
            throw new IllegalArgumentException("빈 커스텀 구분자는 허용되지 않습니다.");
        }
    }

    private record Parsed(String delimiter, String body) {
    }
}
