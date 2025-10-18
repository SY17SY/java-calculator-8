package calculator;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] tokens = split(input);
        int sum = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            sum += num;
        }
        return sum;
    }

    private static String[] split(String input) {
        if (input.contains(",") || input.contains(":")) {
            return input.split("[,:]");
        }
        return new String[]{input};
    }
}
