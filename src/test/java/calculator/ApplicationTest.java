package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("빈 문자열 입력")
    void emptyInput_returnsZero() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("한 개의 숫자 입력")
    void singleNumInput_returnsItself() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("기본 구분자 쉼표 사용")
    void commaDelimiter_sumNumbers() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("기본 구분자 콜론 사용")
    void colonDelimiter_sumNumbers() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 사용")
    void customDelimiter_sumNumbers() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 사용 (Enter)")
    void customDelimiter_enter() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("연속된 구분자 사용")
    void doubleDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1;;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("숫자 구분자 사용")
    void numberDelimiter() {
        assertSimpleTest(() -> {
            run("//5\\n15253");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("한글 구분자 사용")
    void koreanDelimiter() {
        assertSimpleTest(() -> {
            run("//강\\n1강2강3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("예외 음수 입력")
    void throwsOnNegativeNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 숫자 외 잘못된 입력")
    void throwsOnNonNumber() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//-\\n1-2qwe--3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 정수형 범위 밖 입력")
    void throwsOnOverflowInt() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3000000000,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 빈 구분자")
    void throwsOnMissingDelimiter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
