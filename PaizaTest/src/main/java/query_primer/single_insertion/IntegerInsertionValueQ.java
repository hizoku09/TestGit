package query_primer.single_insertion;

import java.util.Objects;

import valueobjects.IntRange;

final class IntegerInsertionValueQ {
    private final int value;
    private final IntRange constraint;

    private IntegerInsertionValueQ(final int value, final IntRange constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }
    
    static IntegerInsertionValueQ newInstance(final int value, final IntRange constraint) {
        return new IntegerInsertionValueQ(value, constraint);
    }
    
    int getValue() {
        return value;
    }
    
}
