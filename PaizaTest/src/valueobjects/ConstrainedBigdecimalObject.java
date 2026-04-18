package valueobjects;
import java.math.BigDecimal;
import java.util.Objects;

public final class ConstrainedBigdecimalObject {
    private final BigDecimal value;
    private final DecimalConstraint constraint;

    public ConstrainedBigdecimalObject (final BigDecimal value, final DecimalConstraint constraint) {
        this.value = Objects.requireNonNull(value);
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(this.value);
    }

    public BigDecimal getValue() {
        return value;
    }
    
}