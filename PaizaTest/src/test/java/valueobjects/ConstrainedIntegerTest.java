package valueobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConstrainedIntegerTest {

    @Test
    @DisplayName("int 型変数 Q を受け取る")
    void testIllegalCheck_integer() {
        final int Q = 4;
        
        final IntRange oneTo100 = new IntRange(1, 100);
        final ConstrainedInteger naturalNumber1To100 = 
                new ConstrainedInteger(Q, oneTo100);

        assertEquals(Q, naturalNumber1To100.getValue());
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final IntRange oneTo100 = new IntRange(1, 100);
        
        assertThrows(
                IllegalArgumentException.class,
                () -> new ConstrainedInteger(0, oneTo100));
        assertThrows(
                IllegalArgumentException.class,
                () -> new ConstrainedInteger(101, oneTo100));
    }

}
