package baseball;

import baseball.type.Command;
import nextstep.utils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Player {

    public Player() {
    }

    public int enterNumber(int length) {
        String input = Console.readLine();
        this.validateInput(input, length);

        return Integer.parseInt(input);
    }

    private void validateInput(String input, int length) {
        this.checkDigit(input);
        this.checkLength(input, length);
        this.checkDuplicate(input, length);
    }

    private void checkDigit(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    private void checkLength(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("[ERROR] " + length + "자리의 숫자를 입력해주세요");
        }
    }

    private void checkDuplicate(String input, int length) {
        Set<String> letters = new HashSet<>(Arrays.asList(input.split("")));
        if (letters.size() != length) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요");
        }
    }

    public boolean playNewGame() {
        String input = Console.readLine();
        try {
            return Command.valueOf(input) == Command.PLAY;
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요");
        }
    }
}
