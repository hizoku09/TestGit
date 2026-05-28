package valueobjects;

import java.util.Objects;

public final class ConstrainedInteger {
    private final int value;
    private final IntRange constraint;

    public ConstrainedInteger(final int value, final IntRange constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public ConstrainedInteger add(final int other) {
        final int added = this.value + other;
        return new ConstrainedInteger(added, constraint);
    }
    
}