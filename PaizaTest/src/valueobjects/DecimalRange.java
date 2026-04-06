package valueobjects;

import java.math.BigDecimal;
import java.util.Objects;

public final class DecimalRange implements DecimalConstraint {
    private final BigDecimal minInclusive;
    private final BigDecimal maxExclusive;

    public DecimalRange(final BigDecimal minInclusive, final BigDecimal maxExclusive) {
        this.minInclusive = Objects.requireNonNull(minInclusive);
        this.maxExclusive = Objects.requireNonNull(maxExclusive);
        if (minInclusive.compareTo(maxExclusive) >= 0) {
            throw new IllegalArgumentException("最小値は最大値以下に指定してください。");
        }
    }

    public void validate(final BigDecimal value) {
        if (value.compareTo(minInclusive) < 0) {
            throw new IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。");
        }
        if (value.compareTo(maxExclusive) >= 0) {
            throw new IllegalArgumentException("数値は " + maxExclusive + " 未満で入力してください。");
        }
    }
    
}