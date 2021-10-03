package baseball;

import baseball.type.Command;
import nextstep.utils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Player {

    public Player() {
    }

    public String enterNumber(int length) {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        this.validateInput(input, length);

        return input;
    }

    private void validateInput(String input, int length) {
        this.checkDigitExceptZero(input);
        this.checkLength(input, length);
        this.checkDuplicate(input, length);
    }

    private void checkDigitExceptZero(String input) {
        if (!input.matches("[1-9]*")) {
            throw new IllegalArgumentException("[ERROR] 1부터 9사이의 숫자를 입력해주세요");
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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        try {
            Command command = Command.commandOf(input)
                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요"));
            return command == Command.PLAY;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return playNewGame();
        }
    }
}
