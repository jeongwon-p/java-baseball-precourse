package baseball;

import nextstep.utils.Console;

public class Player {

    public Player() {
    }

    public int enterNumber(int length) {
        String input = Console.readLine();
        if (!this.validateInput(input, length)) {
            throw new IllegalArgumentException("[ERROR] 올바른 값을 입력해주세요");
        }
        return Integer.parseInt(input);
    }

    private boolean validateInput(String input, int length) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            return false;
        }
        return input.length() == length;
    }
}
