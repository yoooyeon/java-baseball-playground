package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.commons.util.StringUtils.isBlank;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    /**
     * 요구사항 1
     **/
    @Test
    void size() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }
    /**
     * 요구사항 2
     **/
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertTrue(isBlank(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void ints(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    /**
     * 요구사항 3
     **/
    @ParameterizedTest
    @CsvSource(value = {"1,2,3:true", "4,5:false"}, delimiter = ':')
    void contains2(String input, boolean expected) {
        System.out.println("expected = " + expected);
        String[] split = input.split(",");
        for (String s : split) {
            assertThat(numbers.contains(Integer.parseInt(s))).isEqualTo(expected);
        }
    }
}
