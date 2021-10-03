package baseball.type;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Command {
    PLAY("1"),
    EXIT("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Optional<Command> commandOf(String value) {
        return Optional.ofNullable(getCommandMap().get(value));
    }

    private static Map<String, Command> getCommandMap() {
        Map<String, Command> commandMap = new HashMap<>();
        for (int i = 0; i < Command.values().length; i++) {
            commandMap.put(Command.values()[i].value, Command.values()[i]);
        }
        return commandMap;
    }

    public String getValue() {
        return value;
    }
}
