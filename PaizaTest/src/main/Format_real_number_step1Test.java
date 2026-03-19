package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Format_real_number_step1Test {

    @Test
    @DisplayName("double 型変数 N を受け取り、実数に変換する")
    void testRealNumber() {
        final double[] N = { 0.813, 99.0 };
        Format_real_number_step1 rn1 = new Format_real_number_step1(N[0]);
        Format_real_number_step1 rn2 = new Format_real_number_step1(N[1]);

        assertEquals(0.813, rn1.value);
        assertEquals(99.0, rn2.value);
    }

    @Test
    @DisplayName("指定条件のバリデーションチェック")
    void testValidation() {
        double[] N = { 0.0001, 100.0 };
        for (double n : N) {
            assertThrows(IllegalArgumentException.class, () -> {
                Format_real_number_step1 rn = new Format_real_number_step1(n);
            });
        }
    }
}
