package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     **/
    @Test
    void split() {
        String[] split = "1,".split(",");
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1");
    }

    @Test
    void splitMoreThanOne() {
        String[] split = "1,2".split(",");
        assertThat(split).contains("1", "2");
        assertThat(split).containsExactly("1", "2");
    }

    /**
     * 요구사항 2
     **/
    @Test
    void splitIncludingBracket() {
        String[] split = "(1,2)".substring(1,4).split(",");
        assertThat(split).contains("1","2");
        assertThat(split).containsExactly("1","2");
    }

    /**
     * 요구사항 3
     **/
    @Test
    @DisplayName("문자열의 위치 값을 벗어나면 IndexOutOfBoundsException 발생")
    void IndexOutOfBoundsException() {
        assertThatThrownBy(() -> {
            char c = "abc".charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
    }
    @Test
    @DisplayName("문자열의 위치 값을 벗어나면 IndexOutOfBoundsException 발생")
    void IndexOutOfBoundsException2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() ->{
                    char c = "abc".charAt(3);
                }).withMessageMatching("String index out of range: 3");
    }
}
