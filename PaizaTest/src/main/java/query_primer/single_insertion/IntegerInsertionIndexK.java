package query_primer.single_insertion;

import java.util.Objects;

import valueobjects.IntRange;

final class IntegerInsertionIndexK {
    private final int value;
    private final IntRange constraint;

    private IntegerInsertionIndexK(final int value, final IntRange constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }
    
    static IntegerInsertionIndexK newInstance(final int value, final IntRange constraint) {
        return new IntegerInsertionIndexK(value, constraint);
    }
    
    int getValue() {
        return value;
    }
    
}
