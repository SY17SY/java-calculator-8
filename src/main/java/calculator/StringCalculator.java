package calculator;

import java.util.List;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",:";

    public static int add(String input) {
        if (isBlank(input)) {
            return 0;
        }

        List<String> tokens = split(input);
        List<Integer> nums = toNaturalNums(tokens);
        return sum(nums);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static List<String> split(String input) {
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

    private record Parsed(String delimiter, String body) {
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

    private static boolean hasCustomPrefix(String input) {
        return input.startsWith("//");
    }

    private static boolean hasCustomSuffix(String input) {
        return input.contains("\\n");
    }

    private static String addCustomDelimiter(String input, int idx) {
        String customDelimiter = input.substring(2, idx);
        validateCustomEmpty(customDelimiter);
        String delimiter = DEFAULT_DELIMITER + customDelimiter;
        return "[" + delimiter + "]";
    }

    private static void validateCustomEmpty(String custom) {
        if (isBlank(custom)) {
            throw new IllegalArgumentException("빈 커스텀 구분자는 허용되지 않습니다.");
        }
    }

    private static List<Integer> toNaturalNums(List<String> tokens) {
        List<Integer> nums = new java.util.ArrayList<>(List.of());

        for (String token : tokens) {
            if (isBlank(token)) {
                continue;
            }
            int num = getNumValidateNonNumeric(token);
            validateNumNegative(num);
            nums.add(num);
        }
        return nums;
    }

    private static int getNumValidateNonNumeric(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값은 허용되지 않습니다: " + token);
        }
    }

    private static void validateNumNegative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
        }
    }

    private static int sum(List<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
