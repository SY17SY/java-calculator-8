package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void emptyString_returnZero() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void singleNumber_returnsItself() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void commaOrColonDelimiters_sumNumbers() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void customDelimiter_basic() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void customDelimiter_mixedWithDefaultDelimiter() {
        assertSimpleTest(() -> {
            run("//|\\n1|2,3:4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void customDelimiter_escapeEnter() {
        assertSimpleTest(() -> {
            run("//;\n1;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void throwsOnNegativeNumbers() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("-1,2,3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void throwsOnNonNumericToken() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1,a:3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void throwsOnMissingDelimiter() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("//\\n1,2")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void trailingDelimiter_sumNumbers() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void largeNum() {
        assertSimpleTest(() -> {
            run("//;\\n12341234;23411234:23");
            assertThat(output()).contains("결과 : 35752491");
        });
    }

    @Test
    void throwsOnOverflowNum() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//;\\n123412341234;12341234")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
