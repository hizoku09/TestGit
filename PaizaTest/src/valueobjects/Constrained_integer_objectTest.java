package valueobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Constrained_integer_objectTest {

    @Test
    @DisplayName("int 型変数 Q を受け取る")
    void testIllegalCheck_integer() {
        final int Q = 4;
        
        final IntConstraint oneToHundred = new IntRange(1, 101);

        final Constrained_integer_object naturalNumberOneToHundred = 
                new Constrained_integer_object(Q, oneToHundred);

        assertEquals(Q, naturalNumberOneToHundred.getValue());
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final int[] Q = { 0, 101 };
        
        final IntConstraint oneToHundred = new IntRange(1, 101);

        assertThrows(IllegalArgumentException.class, () -> {
            Constrained_integer_object naturalNumber1 = new Constrained_integer_object(Q[0], oneToHundred);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Constrained_integer_object naturalNumber2 = new Constrained_integer_object(Q[1], oneToHundred);
        });
    }

}
