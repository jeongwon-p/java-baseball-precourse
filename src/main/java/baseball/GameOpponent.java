package baseball;

import baseball.type.GameStatus;
import nextstep.utils.Randoms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class GameOpponent {

    private final int length;
    private final Set<Integer> gameNumbers;
    private GameStatus status;

    public GameOpponent(int length) {
        this.length = length;
        this.gameNumbers = this.makeGameNumber();
        this.status = GameStatus.PLAYING;
    }

    private Set<Integer> makeGameNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() != length) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }

        return numbers;
    }

    public Set<Integer> getGameNumbers() {
        return gameNumbers;
    }

    public GameStatus getStatus() {
        return status;
    }

    private int getStrikeCount(String inputNumber) {
        int strikeCount = 0;

        Iterator<Integer> iterator = gameNumbers.iterator();
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
        return gameNumbers.contains(number);
    }
}
