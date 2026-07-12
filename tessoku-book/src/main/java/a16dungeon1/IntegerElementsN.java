package a16dungeon1;

import java.util.Objects;

import valueobjects.IntRange;

final class IntegerElementsN {
    private final int value;
    private final IntRange constraint;

    private IntegerElementsN(final int value, final IntRange constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }
    
    static IntegerElementsN newInstance(final int value, final IntRange constraint) {
        return new IntegerElementsN(value, constraint);
    }
    
    int getValue() {
        return value;
    }
    
}
