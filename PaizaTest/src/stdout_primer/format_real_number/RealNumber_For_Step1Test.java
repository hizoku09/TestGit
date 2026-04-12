package stdout_primer.format_real_number;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealNumber_For_Step1Test {

    @Test
    @DisplayName("double 型変数 N を受け取り、実数に変換する")
    void testIllegalCheck_format_real_number_step1() {
        final double[] N = { 0.813, 99.0 };
        RealNumber_For_Step1 RealNumber1 = new RealNumber_For_Step1(N[0]);
        RealNumber_For_Step1 RealNumber2 = new RealNumber_For_Step1(N[1]);

        assertEquals(0.813, RealNumber1.value);
        assertEquals(99.0, RealNumber2.value);
    }

    @Test
    @DisplayName("指定条件のバリデーションチェック")
    void testValidation() {
        double[] N = { 0.0001, 100.0 };

        assertThrows(IllegalArgumentException.class, () -> {
            RealNumber_For_Step1 ReanlNumber1 = new RealNumber_For_Step1(N[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RealNumber_For_Step1 RealNumber2 = new RealNumber_For_Step1(N[1]);
        });
    }
}
