package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    void nothing() {
        Balls balls = new Balls(Arrays.asList(1,2,3));
        PlayResult res = balls.play(Arrays.asList(4, 5, 6));
        assertThat(res.getNothing()).isEqualTo(3);
        assertThat(res.getBall()).isEqualTo(0);
        assertThat(res.getStrike()).isEqualTo(0);
    }

    @Test
    void ball() {
        Balls balls = new Balls(Arrays.asList(1,2,3));
        PlayResult res = balls.play(Arrays.asList(3, 2, 4));
        assertThat(res.getNothing()).isEqualTo(1);
        assertThat(res.getBall()).isEqualTo(1);
        assertThat(res.getStrike()).isEqualTo(1);
    }

    @Test
    void strike() {
        Balls balls = new Balls(Arrays.asList(1,2,3));
        PlayResult res = balls.play(Arrays.asList(1, 2, 4));
        assertThat(res.getNothing()).isEqualTo(1);
        assertThat(res.getBall()).isEqualTo(0);
        assertThat(res.getStrike()).isEqualTo(2);
    }
}
