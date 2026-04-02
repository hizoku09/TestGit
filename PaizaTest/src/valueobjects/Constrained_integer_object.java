package valueobjects;

import java.util.Objects;

public final class Constrained_integer_object {
    private final int value;
    private final IntConstraint constraint;

    public Constrained_integer_object(final int value, final IntConstraint constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}