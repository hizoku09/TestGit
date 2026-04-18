package valueobjects;

import java.util.Objects;

public final class ConstrainedIntegerObject {
    private final int value;
    private final IntConstraint constraint;

    public ConstrainedIntegerObject(final int value, final IntConstraint constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}