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
