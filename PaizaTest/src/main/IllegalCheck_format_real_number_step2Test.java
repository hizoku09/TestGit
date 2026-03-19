package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IllegalCheck_format_real_number_step2Test {

    @Test
    @DisplayName("double 型変数 N を受け取り、実数に変換する")
    void testIllegalCheck_format_real_number_step2() {
        final double[] N = { 0.813, 10000000000.5 };
        IllegalCheck_format_real_number_step2 IllegalChecked_rn1 = new IllegalCheck_format_real_number_step2(N[0]);
        IllegalCheck_format_real_number_step2 IllegalChecked_rn2 = new IllegalCheck_format_real_number_step2(N[1]);

        assertEquals(0.813, IllegalChecked_rn1.getValue());
        assertEquals(10000000000.5, IllegalChecked_rn2.getValue());
    }

    @Test
    @DisplayName("指定条件のバリデーションチェック")
    void testValidation() {
        double[] N = { 0.0001, 999999999999.999 };

        assertThrows(IllegalArgumentException.class, () -> {
            IllegalCheck_format_real_number_step2 IllegalChecked_rn1 =
                    new IllegalCheck_format_real_number_step2(N[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            IllegalCheck_format_real_number_step2 IllegalChecked_rn2 = 
                    new IllegalCheck_format_real_number_step2(N[1]);
        });
    }
}
