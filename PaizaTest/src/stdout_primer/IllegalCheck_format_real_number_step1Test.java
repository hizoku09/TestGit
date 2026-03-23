package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IllegalCheck_format_real_number_step1Test {

    @Test
    @DisplayName("double 型変数 N を受け取り、実数に変換する")
    void testIllegalCheck_format_real_number_step1() {
        final double[] N = { 0.813, 99.0 };
        IllegalCheck_format_real_number_step1 IllegalChecked_rn1 = 
                new IllegalCheck_format_real_number_step1(N[0]);
        IllegalCheck_format_real_number_step1 IllegalChecked_rn2 = 
                new IllegalCheck_format_real_number_step1(N[1]);

        assertEquals(0.813, IllegalChecked_rn1.getValue());
        assertEquals(99.0, IllegalChecked_rn2.getValue());
    }

    @Test
    @DisplayName("指定条件のバリデーションチェック")
    void testValidation() {
        double[] N = { 0.0001, 100.0 };

        assertThrows(IllegalArgumentException.class, () -> {
            IllegalCheck_format_real_number_step1 IllegalChecked_rn1 = 
                    new IllegalCheck_format_real_number_step1(N[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            IllegalCheck_format_real_number_step1 IllegalChecked_rn2 = 
                    new IllegalCheck_format_real_number_step1(N[1]);
        });
    }
}
