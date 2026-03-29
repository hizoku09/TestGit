package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NaturalNumber_1to4Test {

    @Test
    @DisplayName("int 型変数 M を受け取る")
    void testIllegalCheck_Integer_step4() {
        final int[] M = { 1, 2, 3, 4 };

        for (int m : M) {
            NaturalNumber_1to4 Integer = new NaturalNumber_1to4(m);
            assertEquals(m, Integer.value);
        }
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final int[] M = { 0, 5 };

        assertThrows(IllegalArgumentException.class, () -> {
            NaturalNumber_1to4 Integer1 = new NaturalNumber_1to4(M[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            NaturalNumber_1to4 Integer2 = new NaturalNumber_1to4(M[1]);
        });
    }

}
