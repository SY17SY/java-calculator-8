package calculator.domain;

import calculator.domain.validator.DelimiterValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\\\\n(.*)");

    public TokenizedInput parse(String input) {
        if (input == null || input.isBlank()) {
            return new TokenizedInput(DEFAULT_DELIMITER, "");
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            DelimiterValidator.validate(customDelimiter);
            String delimiters = DEFAULT_DELIMITER + "|" + customDelimiter;
            String targetString = matcher.group(2);
            return new TokenizedInput(delimiters, targetString);
        }

        return new TokenizedInput(DEFAULT_DELIMITER, input);
    }
}
