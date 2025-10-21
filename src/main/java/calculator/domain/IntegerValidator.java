package calculator.domain;

public class IntegerValidator {
    public static int validate(String value) {
        if (value == null) {
            return 0;
        }

        String s = value.trim();
        if (s.isEmpty()) {
            return 0;
        }

        if (value.startsWith("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }

        try {
            long longValue = Long.parseLong(value); // 범위 체크를 위해 Long 사용
            integerOverflow(longValue);
            return (int) longValue;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("형식이 올바르지 않습니다.");
        }
    }

    public static void integerOverflow(Long value) {
        if (value > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Integer 범위를 벗어나는 수는 허용되지 않습니다.");
        }
    }
}
