package baseball;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Opponent {

    private final int length;
    private final Set<Integer> gameNumbers;

    public Opponent(int length) {
        this.length = length;
        this.gameNumbers = this.makeGameNumber();
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
}
