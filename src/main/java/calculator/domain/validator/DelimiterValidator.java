package calculator.domain.validator;

public final class DelimiterValidator {
    public static void validate(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("빈 구분자는 허용되지 않습니다.");
        }
        if (delimiter.length() > 1) {
            throw new IllegalArgumentException("2개 이상의 문자로 이루어진 구분자는 허용되지 않습니다.");
        }
    }
}
