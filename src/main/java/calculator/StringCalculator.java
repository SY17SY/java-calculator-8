package calculator;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",:";

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = split(input);
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            try {
                int num = Integer.parseInt(token);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값은 허용되지 않습니다: " + token);
            }
        }
        return sum;
    }

    private static String[] split(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            int idx = input.indexOf("\\n");
            String body = input.substring(idx + 2);

            String customDelimiter = input.substring(2, idx);
            String delimiter = "[" + DEFAULT_DELIMITER + customDelimiter + "]";
            return body.split(delimiter);
        }
        String defaultDelimiter = "[" + DEFAULT_DELIMITER + "]";
        return input.split(defaultDelimiter);
    }
}
