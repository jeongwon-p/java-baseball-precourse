package baseball;

public class Application {

    private static final int NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        Player player = new Player();

        do {
            Opponent opponent = new Opponent(NUMBER_LENGTH);
            Game game = new Game(opponent, player, NUMBER_LENGTH);
            game.play();
        } while (player.playNewGame());
    }
}
