package baseball;

public class PlayResult {
    private int nothing = 0;
    private int strike = 0;
    private int ball = 0;

    public void report(BallStatus status) {
        if (status.isNothing()) {
            nothing += 1;
        }
        if (status.isBall()) {
            ball += 1;
        }
        if (status.isStrike()) {
            strike += 1;
        }

    }

    public int getNothing() {
        return nothing;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
