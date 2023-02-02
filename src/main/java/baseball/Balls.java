package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    List<Ball> balls;

    public Balls(List<Integer> ballNos) {
        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < ballNos.size(); i++) {
            Ball ball = new Ball(i + 1, ballNos.get(i));
            balls.add(ball);
        }
        this.balls = balls;
    }

    public PlayResult play(List<Integer> asList) {
        Balls userBall = new Balls(asList);
        PlayResult result = new PlayResult();
        for (Ball ball : balls) {
            BallStatus status = userBall.play(ball);
            result.report(status);
        }
        return result;
    }

    private BallStatus play(Ball ball) {
        return balls.stream()
                .map(answer -> answer.play(ball)
                ).filter(status -> !status.isNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
