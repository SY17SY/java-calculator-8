package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class NumberExtractor {
    private final DelimiterParser delimiterParser;

    public NumberExtractor(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
    }

    public List<Integer> extract(String stringInput) {
        String[] stringInputs = splitString(stringInput);
        return Arrays.stream(stringInputs)
                .mapToInt(Integer::parseInt)
                .boxed().toList();
    }

    private String[] splitString(String input) {
        TokenizedInput delimiterAndTarget = delimiterParser.parse(input);
        String delimiter = delimiterAndTarget.delimiter();
        String targetString = delimiterAndTarget.targetString();

        return targetString.split(delimiter);
    }
}
