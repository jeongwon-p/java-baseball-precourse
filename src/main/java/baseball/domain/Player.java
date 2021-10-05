package baseball.domain;

import baseball.type.Command;
import nextstep.utils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.config.GameConfig.NUMBER_LENGTH;

public class Player {

    public Player() {
    }

    public String enterNumber() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        this.validateInput(input);

        return input;
    }

    public void validateInput(String input) {
        this.checkDigitExceptZero(input);
        this.checkLength(input);
        this.checkDuplicate(input);
    }

    private void checkDigitExceptZero(String input) {
        if (!input.matches("[1-9]*")) {
            throw new IllegalArgumentException("[ERROR] 1부터 9사이의 숫자를 입력해주세요");
        }
    }

    private void checkLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] " + NUMBER_LENGTH + "자리의 숫자를 입력해주세요");
        }
    }

    private void checkDuplicate(String input) {
        Set<String> letters = new HashSet<>(Arrays.asList(input.split("")));
        if (letters.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않은 숫자를 입력해주세요");
        }
    }

    public boolean playNewGame() {
        try {
            System.out.println("게임을 새로 시작하려면 " + Command.PLAY.getValue() + ", 종료하려면 " + Command.EXIT.getValue() + "를 입력하세요.");
            return this.isNewGame(Console.readLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return playNewGame();
        }
    }

    public boolean isNewGame(String input) {
        Command command = Command.commandOf(input)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요."));
        return command == Command.PLAY;
    }
}
