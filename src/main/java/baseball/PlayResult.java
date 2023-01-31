package baseball;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;
    private int nothing = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public int getNothing() {
        return this.nothing;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            strike += 1;
        } else if (status.isBall()) {
            ball += 1;
        } else if (status.isNothing()) {
            nothing += 1;
        }
    }
}
