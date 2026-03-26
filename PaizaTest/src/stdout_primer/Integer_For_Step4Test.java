package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Integer_For_Step4Test {

    @Test
    @DisplayName("int 型変数 M を受け取る")
    void testIllegalCheck_Integer_step4() {
        final int[] M = { 1, 2, 3, 4 };
        
        Integer_For_Step4 Integer1 = new Integer_For_Step4(M[0]);
        Integer_For_Step4 Integer2 = new Integer_For_Step4(M[1]);
        Integer_For_Step4 Integer3 = new Integer_For_Step4(M[2]);
        Integer_For_Step4 Integer4 = new Integer_For_Step4(M[3]);

        assertEquals(1, Integer1.value);
        assertEquals(2, Integer2.value);
        assertEquals(3, Integer3.value);
        assertEquals(4, Integer4.value);
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final int[] M = { 0, 5 };

        assertThrows(IllegalArgumentException.class, () -> {
            Integer_For_Step4 Integer1 = new Integer_For_Step4(M[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Integer_For_Step4 Integer2 = new Integer_For_Step4(M[1]);
        });
    }
    
}
