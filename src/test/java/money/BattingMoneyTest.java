package money;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BattingMoneyTest {

    @DisplayName("BattingMoney 객체를 생성하는 기능을 테스트한다")
    @Test
    void testInitBattingMoney() {
        //given
        int value = 0;

        //when
        BattingMoney battingMoney = new BattingMoney(value);

        //then
        assertThat(battingMoney).extracting("value").isEqualTo(value);
    }

    @DisplayName("배팅금액이 음수이면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(ints = {
            -1, -2, -3, -4, -5
    })
    void testInitBattingMoneyIfBattingMoneyValueIsNegative(int value) {
        //when //then
        assertThatThrownBy(() -> new BattingMoney(value))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
