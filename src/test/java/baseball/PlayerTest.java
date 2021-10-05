package baseball;

import static baseball.config.GameConfig.NUMBER_LENGTH;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @DisplayName("'1' 입력 시 new game 진행")
    @Test
    void isNewGameTest() {
        assertTrue(player.isNewGame("1"));
    }

    @DisplayName("'2' 입력 시 game 종료")
    @Test
    void isNotNewGameTest() {
        assertFalse(player.isNewGame("2"));
    }

    @DisplayName("각 자리가 1~9 숫자인지 확인_숫자 0 포함")
    @Test
    void checkDigitExceptZero_zero() {
        assertThatThrownBy(() -> player.validateInput("011"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1부터 9사이의 숫자를 입력해주세요");
    }

    @DisplayName("각 자리가 1~9 숫자인지 확인_문자 포함")
    @Test
    void checkDigitExceptZero_nonDigit() {
        assertThatThrownBy(() -> player.validateInput("a12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1부터 9사이의 숫자를 입력해주세요");
    }

    @DisplayName("N자리 수인지 체크")
    @Test
    void checkLength() {
        assertThatThrownBy(() -> player.validateInput("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] " + NUMBER_LENGTH + "자리의 숫자를 입력해주세요");
    }

    @DisplayName("중복 숫자 체크")
    @Test
    void checkDuplicate() {
        assertThatThrownBy(() -> player.validateInput("111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복되지 않은 숫자를 입력해주세요");
    }
}
