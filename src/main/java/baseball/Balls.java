package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;


    public Balls(List<Integer> ballNos) {
        this.balls = mapBall(ballNos);
    }

    private List<Ball> mapBall(List<Integer> ballNos) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < ballNos.size(); i++) {
            balls.add(new Ball(i + 1, ballNos.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(answer -> answer.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(List<Integer> ballNos) {
        Balls userBalls = new Balls(ballNos);
        PlayResult result = new PlayResult();
        for (Ball ball : balls) {
            BallStatus status = userBalls.play(ball);
            result.report(status);
        }
        return result;
    }
}
