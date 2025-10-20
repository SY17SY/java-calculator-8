package calculator;

import calculator.parser.InputParser;
import java.util.List;

public class StringCalculator {
    public static int add(String input) {
        if (isBlank(input)) {
            return 0;
        }

        List<String> tokens = InputParser.parse(input);
        List<Integer> nums = toNaturalNums(tokens);
        return sum(nums);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static List<Integer> toNaturalNums(List<String> tokens) {
        List<Integer> nums = new java.util.ArrayList<>(List.of());

        for (String token : tokens) {
            if (isBlank(token)) {
                continue;
            }
            int num = getNumValidated(token);
            nums.add(num);
        }
        return nums;
    }

    private static int getNumValidated(String token) {
        try {
            int num = Integer.parseInt(token);
            validateNumNegative(num);
            return num;
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
