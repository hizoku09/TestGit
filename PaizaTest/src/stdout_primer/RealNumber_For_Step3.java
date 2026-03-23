package stdout_primer;

import java.math.BigDecimal;
import java.math.RoundingMode;

class RealNumber_For_Step3 {

    private static final double MAX = 99.999999;
    private static final double MIN = 0.001;
    final double value;

    RealNumber_For_Step3(final double value) {
        illegalcheck(value);
        final double decimalplacesChecked_RealNumber = decimalplacesCheck(value);
        this.value = decimalplacesChecked_RealNumber;
    }

    public void illegalcheck(final double value) {
        if (value < MIN) {
            throw new IllegalArgumentException("数値は " + MIN + " 以上で入力してください。");
        }
        if (value >= MAX) {
            throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。");
        }
    }

    double decimalplacesCheck(final double value) {
        BigDecimal result = BigDecimal.valueOf(value);

        if (result.scale() >= 4)
            result = result.setScale(3, RoundingMode.HALF_UP);

        return result.doubleValue();
    }

}
