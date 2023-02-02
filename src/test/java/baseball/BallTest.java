package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    @Test
    void nothing() {
        Ball ball = new Ball(1, 1);
        BallStatus status = ball.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        Ball ball = new Ball(1, 1);
        BallStatus status = ball.play(new Ball(2, 1));
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Ball ball = new Ball(1, 1);
        BallStatus status = ball.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
