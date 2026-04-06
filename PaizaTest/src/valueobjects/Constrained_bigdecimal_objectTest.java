package valueobjects;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Constrained_bigdecimal_objectTest {

    @Test
    @DisplayName("BigDecimal 型変数 N を受け取る")
    void testIllegalCheck_bigdecimal() {
        final BigDecimal[] N = { new BigDecimal(0.813), new BigDecimal(8.13), new BigDecimal(3.141692) };
        final DecimalConstraint Greater0_001Under99_999999 = new DecimalRange(new BigDecimal(0.001),
                new BigDecimal(99.999999));

        for (BigDecimal n : N) {
            final Constrained_bigdecimal_object realNumberGreater0_001Under99_999999 = new Constrained_bigdecimal_object(
                    n, Greater0_001Under99_999999);

            assertEquals(n, realNumberGreater0_001Under99_999999.getValue());
        }
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final BigDecimal[] N = { new BigDecimal(0.0001), new BigDecimal(99.999999) };
        final DecimalConstraint Greater0_001Under99_999999 = new DecimalRange(new BigDecimal(0.001),
                new BigDecimal(99.999999));

        assertThrows(IllegalArgumentException.class, () -> {
            Constrained_bigdecimal_object realNumber1 = new Constrained_bigdecimal_object(N[0],
                    Greater0_001Under99_999999);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Constrained_bigdecimal_object realNumber2 = new Constrained_bigdecimal_object(N[1],
                    Greater0_001Under99_999999);
        });
    }

}
