package calculator.domain;

import calculator.dto.SplitStringDto;
import java.util.Arrays;

public class NumberSeparator {
    private final DelimiterGenerator delimiterGenerator;

    public NumberSeparator(DelimiterGenerator delimiterGenerator) {
        this.delimiterGenerator = delimiterGenerator;
    }

    public int[] splitNum(String stringInputs) {
        String[] splitedString = splitString(stringInputs);
        return Arrays.stream(splitedString)
                .mapToInt(s -> s.isEmpty() ? 0 : Integer.parseInt(s))
                .toArray();
    }

    private String[] splitString(String inputs) {
        SplitStringDto delimiterAndTarget = delimiterGenerator.splitString(inputs);
        String delimiter = delimiterAndTarget.delimiter();
        String targetString = delimiterAndTarget.targetString();

        return targetString.split(delimiter);
    }
}
