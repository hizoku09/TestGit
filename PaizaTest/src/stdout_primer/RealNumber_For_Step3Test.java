package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealNumber_For_Step3Test {

    @Test
    @DisplayName("double 型変数 N を受け取り、小数点第四位で四捨五入する")
    void testIllegalCheck_format_real_number_step3() {
        final double[] N = { 0.813, 8.13, 3.141692 };
        
        RealNumber_For_Step3 RealNumber1 = new RealNumber_For_Step3(N[0]);
        RealNumber_For_Step3 RealNumber2 = new RealNumber_For_Step3(N[1]);
        RealNumber_For_Step3 RealNumber3 = new RealNumber_For_Step3(N[2]);

        assertEquals(0.813, RealNumber1.value);
        assertEquals(8.13, RealNumber2.value);
        assertEquals(3.142, RealNumber3.value);
    }

    @Test
    @DisplayName("最大値・最小値のバリデーションチェック")
    void testMax_Min_Validation() {
        final double[] N = { 0.0001, 99.999999 };

        assertThrows(IllegalArgumentException.class, () -> {
            RealNumber_For_Step3 RealNumber1 = new RealNumber_For_Step3(N[0]);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            RealNumber_For_Step3 RealNumber2 = new RealNumber_For_Step3(N[1]);
        });
    }
    
}
