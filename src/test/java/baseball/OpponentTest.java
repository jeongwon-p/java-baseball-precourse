package baseball;

import static org.junit.jupiter.api.Assertions.*;

import baseball.config.GameConfig;
import baseball.domain.Opponent;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OpponentTest {

    private Opponent opponent;

    @BeforeEach
    void setUp() {
        opponent = new Opponent();
    }

    @DisplayName("랜덤 생성된 게임 숫자 자리수 체크")
    @Test
    void makeGameNumber_ShouldGenerateTheNumberOfExpectedLength() {
        Set<Integer> gameNumbers = opponent.getGameNumbers();
        assertEquals(GameConfig.NUMBER_LENGTH, gameNumbers.size());
    }

    @DisplayName("랜덤 생성된 게임 숫자 범위(1~9) 체크 체크")
    @Test
    void makeGameNumber_ShouldNotDuplicateNumber() {
        Set<Integer> gameNumbers = opponent.getGameNumbers();
        for (Integer number : gameNumbers) {
            assertTrue(number >= 1);
            assertTrue(number <= 9);
        }
    }
}
