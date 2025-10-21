package calculator.domain;

import calculator.dto.SplitStringDto;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public SplitStringDto parse(String input) {
        if (input == null || input.isBlank()) {
            return new SplitStringDto(DEFAULT_DELIMITER, "");
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String targetString = matcher.group(2);
            return new SplitStringDto(customDelimiter, targetString);
        }

        return new SplitStringDto(DEFAULT_DELIMITER, input);
    }
}
