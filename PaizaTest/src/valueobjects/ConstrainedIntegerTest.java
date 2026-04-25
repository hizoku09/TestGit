package valueobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConstrainedIntegerTest {

    @Test
    @DisplayName("int 型変数 Q を受け取る")
    void testIllegalCheck_integer() {
        final int Q = 4;
        
        final IntRange oneToHundred = new IntRange(1, 101);

        final ConstrainedInteger naturalNumberOneToHundred = 
                new ConstrainedInteger(Q, oneToHundred);

        assertEquals(Q, naturalNumberOneToHundred.getValue());
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final int[] Q = { 0, 101 };
        
        final IntRange oneToHundred = new IntRange(1, 101);

        assertThrows(IllegalArgumentException.class, () -> {
            ConstrainedInteger naturalNumber1 = new ConstrainedInteger(Q[0], oneToHundred);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ConstrainedInteger naturalNumber2 = new ConstrainedInteger(Q[1], oneToHundred);
        });
    }

}
