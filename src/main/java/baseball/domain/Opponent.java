package baseball.domain;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.config.GameConfig.NUMBER_LENGTH;

public class Opponent {

    private final Set<Integer> gameNumbers;

    public Opponent() {
        this.gameNumbers = this.makeGameNumber();
    }

    private Set<Integer> makeGameNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();

        while (numbers.size() != NUMBER_LENGTH) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return numbers;
    }

    public Set<Integer> getGameNumbers() {
        return gameNumbers;
    }
}
