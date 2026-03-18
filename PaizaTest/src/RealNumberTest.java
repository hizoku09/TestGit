import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealNumberTest {

    @Test
    @DisplayName("文字列 N を受け取り、実数に変換する")
    void testRealNumber() {
        String[] N = { "0.813", "99.0" };
        RealNumber rn1 = new RealNumber(N[0]);
        RealNumber rn2 = new RealNumber(N[1]);
        
        assertEquals(0.813, rn1.Number);
        assertEquals(99.0, rn2.Number);
    }

    @Test
    @DisplayName("指定条件のバリデーションチェック")
    void testValidation() {
        String[] N = { "0.0001", "100.0" };
        for (String n : N) {
            assertThrows(IllegalArgumentException.class, () -> {
                RealNumber rn = new RealNumber(n);
            });
        }
    }

    @Test
    @DisplayName("nullチェック")
    void testNull() {
        String N = null;
        assertThrows(NullPointerException.class, () -> {
            RealNumber rn = new RealNumber(N);
        });
    }

}
