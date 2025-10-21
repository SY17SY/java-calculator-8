package calculator.domain;

public class IntegerValidator {
    public static int validate(String value) {
        String s = trimOrNull(value);
        if (s == null) {
            return 0;
        }
        long longValue = parseLongOrIAE(s);
        requireNonNegative(longValue);
        requireIntRange(longValue);
        return (int) longValue;
    }

    private static String trimOrNull(String value) {
        if (value == null) {
            return null;
        }
        String s = value.trim();
        if (s.isEmpty()) {
            return null;
        }
        return s;
    }

    private static long parseLongOrIAE(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("형식이 올바르지 않습니다.");
        }
    }

    public static void requireNonNegative(Long value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    public static void requireIntRange(Long value) {
        if (value > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Integer 범위를 벗어나는 수는 허용되지 않습니다.");
        }
    }
}
