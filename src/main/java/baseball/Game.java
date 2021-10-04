package baseball;

import baseball.type.GameStatus;

import java.util.Iterator;

public class Game {

    private final Opponent opponent;
    private final Player player;
    private final int numberLength;
    private GameStatus status;

    public Game(Opponent opponent, Player player, int numberLength) {
        this.opponent = opponent;
        this.player = player;
        this.numberLength = numberLength;
        this.status = GameStatus.PLAYING;
    }

    public void play() {
        while (this.status == GameStatus.PLAYING) {
            //playTurn();
        }
    }

    private void playTurn() {
        // TODO
    }

    private String judge(int ballCount, int strikeCount) {
        if (strikeCount == numberLength) {
            return success();
        }
        return fail(ballCount, strikeCount);
    }

    private String success() {
        this.status = GameStatus.EXIT;
        return numberLength + "개의 숫자를 모두 맞히셨습니다! 게임 끝";
    }

    private String fail(int ballCount, int strikeCount) {
        if (strikeCount == 0 && ballCount == 0)
            return "낫싱";
        if (ballCount == 0)
            return strikeCount + "스트라이크";
        if (strikeCount == 0)
            return ballCount + "볼";
        return strikeCount + "스트라이크" + ballCount + "볼";
    }

    private int getStrikeCount(String inputNumber) {
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

    private int getBallCount(String inputNumber) {
        int ballCount = 0;

        for (int i = 0; i < inputNumber.length(); i++) {
            ballCount += this.isBall(inputNumber.charAt(i) - '0') ? 1 : 0;
        }
        return ballCount;
    }

    private boolean isBall(int number) {
        return opponent.getGameNumbers().contains(number);
    }
}
