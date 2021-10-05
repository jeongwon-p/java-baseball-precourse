package baseball;

import baseball.domain.Opponent;
import baseball.domain.Player;
import baseball.type.GameStatus;

import java.util.Iterator;

import static baseball.config.GameConfig.*;

public class GameService {

    private final Opponent opponent;
    private final Player player;
    private GameStatus status;

    public GameService(Opponent opponent, Player player) {
        this.opponent = opponent;
        this.player = player;
        this.status = GameStatus.PLAYING;
    }

    public void play() {
        while (this.status == GameStatus.PLAYING) {
            String playerNumber = player.enterNumber();
            System.out.println(this.playTurn(playerNumber));
        }
    }

    protected String playTurn(String playerNumber) {
        try {
            int strikeCount = this.getStrikeCount(playerNumber);
            int ballCount = this.getBallCount(playerNumber, strikeCount);
            return this.judge(ballCount, strikeCount);
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }

    private String judge(int ballCount, int strikeCount) {
        if (strikeCount == NUMBER_LENGTH) {
            return success(strikeCount);
        }
        return fail(ballCount, strikeCount);
    }

    private String success(int strikeCount) {
        this.status = GameStatus.EXIT;
        return strikeCount + HINT_STRIKE + "\n\r" + SUCCESS_MESSAGE;
    }

    private String fail(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0)
            return HINT_NOTHING;
        if (ballCount == 0)
            return strikeCount + HINT_STRIKE;
        if (strikeCount == 0)
            return ballCount + HINT_BALL;
        return strikeCount + HINT_STRIKE + " " + ballCount + HINT_BALL;
    }

    protected int getStrikeCount(String inputNumber) {
        int strikeCount = 0;

        Iterator<Integer> iterator = opponent.getGameNumbers().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            strikeCount += isStrike(iterator.next(), inputNumber.charAt(i) - '0') ? 1 : 0;
        }
        return strikeCount;
    }

    private boolean isStrike(int target, int number) {
        return target == number;
    }

    protected int getBallCount(String inputNumber, int strikeCount) {
        int ballCount = 0;

        for (int i = 0; i < inputNumber.length(); i++) {
            ballCount += this.isBall(inputNumber.charAt(i) - '0') ? 1 : 0;
        }
        return ballCount - strikeCount;
    }

    private boolean isBall(int number) {
        return opponent.getGameNumbers().contains(number);
    }
}
