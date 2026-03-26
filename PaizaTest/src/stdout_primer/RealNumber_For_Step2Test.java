package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealNumber_For_Step2Test {

    @Test
    @DisplayName("double 型変数 N を受け取り、実数に変換する")
    void testIllegalCheck_format_real_number_step2() {
        final double[] N = { 0.813, 10000000000.5 };
        
        RealNumber_For_Step2 RealNumber1 = new RealNumber_For_Step2(N[0]);
        RealNumber_For_Step2 RealNumber2 = new RealNumber_For_Step2(N[1]);

        assertEquals(0.813, RealNumber1.value);
        assertEquals(10000000000.5, RealNumber2.value);
    }

    @Test
    @DisplayName("指定条件のバリデーションチェック")
    void testValidation() {
        double[] N = { 0.0001, 999999999999.999 };

        assertThrows(IllegalArgumentException.class, () -> {
            RealNumber_For_Step2 RealNumber1 = new RealNumber_For_Step2(N[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RealNumber_For_Step2 RealNumber2 = new RealNumber_For_Step2(N[1]);
        });
    }
}
