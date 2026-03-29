package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NaturalNumber_1to100Test {

    @Test
    @DisplayName("int 型変数 Q を受け取る")
    void testIllegalCheck_Integer() {
        final int Q = 4;

        NaturalNumber_1to100 naturalNumber = new NaturalNumber_1to100(Q);
        assertEquals(Q, naturalNumber.value);
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final int[] Q = { 0, 101 };

        assertThrows(IllegalArgumentException.class, () -> {
            NaturalNumber_1to100 naturalNumber1 = new NaturalNumber_1to100(Q[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            NaturalNumber_1to100 naturalNumber2 = new NaturalNumber_1to100(Q[1]);
        });
    }

}
