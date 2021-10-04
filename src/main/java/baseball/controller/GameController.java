package baseball.controller;

import baseball.GameService;
import baseball.domain.Opponent;
import baseball.domain.Player;

public class GameController {

    public void play() {
        Player player = new Player();

        do {
            Opponent opponent = new Opponent();
            GameService gameService = new GameService(opponent, player);
            gameService.play();
        } while (player.playNewGame());
    }
}
