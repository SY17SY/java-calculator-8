package calculator;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (!input.contains(",") && !input.contains("\n")) {
            return Integer.parseInt(input);
        }
        throw new UnsupportedOperationException("미구현");
    }
}
