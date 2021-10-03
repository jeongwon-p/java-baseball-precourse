package baseball.type;

public enum Command {
    PLAY("1"),
    EXIT("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
