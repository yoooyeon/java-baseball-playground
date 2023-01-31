package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class BallsTest {

    @Test
    void play_3nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(4, 5, 6));
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getNothing()).isEqualTo(3);
    }

    @Test
    void play_1strike_2ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 3, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getNothing()).isEqualTo(0);
    }

    @Test
    void play_3strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getNothing()).isEqualTo(0);
    }

    @Test
    void strike() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        assertThat(balls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        assertThat(balls.play(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        assertThat(balls.play(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
    }


//    @BeforeEach
//    void setUp() {
//        com = new Ball(1, 4);
//    }
//
//    @Test
//    void strike() {
//        assertThat(com.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);
//    }
//
//    @Test
//    void ball() {
//        assertThat(com.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
//    }
//
//    @Test
//    void nothing() {
//        assertThat(com.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
//    }
}
