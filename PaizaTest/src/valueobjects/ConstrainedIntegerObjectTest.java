package valueobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConstrainedIntegerObjectTest {

    @Test
    @DisplayName("int 型変数 Q を受け取る")
    void testIllegalCheck_integer() {
        final int Q = 4;
        
        final IntConstraint oneToHundred = new IntRange(1, 101);

        final ConstrainedIntegerObject naturalNumberOneToHundred = 
                new ConstrainedIntegerObject(Q, oneToHundred);

        assertEquals(Q, naturalNumberOneToHundred.getValue());
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final int[] Q = { 0, 101 };
        
        final IntConstraint oneToHundred = new IntRange(1, 101);

        assertThrows(IllegalArgumentException.class, () -> {
            ConstrainedIntegerObject naturalNumber1 = new ConstrainedIntegerObject(Q[0], oneToHundred);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ConstrainedIntegerObject naturalNumber2 = new ConstrainedIntegerObject(Q[1], oneToHundred);
        });
    }

}
