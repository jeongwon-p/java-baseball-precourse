package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.Opponent;
import baseball.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GameServiceTest {

    private GameService gameService;
    private Set<Integer> gameNumbers;

    @BeforeEach
    void setUp() {
        Player player = new Player();
        Opponent opponent = new Opponent();
        gameNumbers = opponent.getGameNumbers();
        gameService = new GameService(opponent, player);
    }

    @DisplayName("3 스트라이크 카운트 테스트")
    @Test
    void getStrikeCountTest() {
        String gameNumberAsString = getGameNumberAsString();
        int strikeCount = gameService.getStrikeCount(gameNumberAsString);
        assertEquals(3, strikeCount);
    }

    @DisplayName("3 볼 카운트 테스트")
    @Test
    void getBallCountTest() {
        String swappedGameNumberAsString = getSwappedGameNumberAsString();
        int strikeCount = gameService.getStrikeCount(swappedGameNumberAsString);
        int ballCount = gameService.getBallCount(swappedGameNumberAsString, strikeCount);
        assertEquals(3, ballCount);
    }

    private String getGameNumberAsString() {
        StringBuilder numberLetter = new StringBuilder();
        for (Integer number : gameNumbers) {
            numberLetter.append(number.toString());
        }
        return numberLetter.toString();
    }

    private String getSwappedGameNumberAsString() {
        StringBuilder numberLetter = new StringBuilder();
        for (int i = 1; i < gameNumbers.size(); i++) {
            numberLetter.append(gameNumbers.toArray()[i].toString());
        }
        numberLetter.append(gameNumbers.toArray()[0]);
        return numberLetter.toString();
    }
}
