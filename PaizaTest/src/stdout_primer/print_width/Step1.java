package stdout_primer.print_width;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Step1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final PaddedNumberPrinter printer = new PaddedNumberPrinter(System.out);
            final IntRange oneTo999 = new IntRange(0, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo999);
            final ConstrainedInteger three = new ConstrainedInteger(3, oneTo999);

            printer.printPaddedNumberHalfWidthSpace(n, three);

        }
    }

}

/*
 * class PaddedNumberPrinter { private final PrintStream out;
 * 
 * PaddedNumberPrinter(final PrintStream out) { this.out = out; }
 * 
 * void printPaddedNumberZero(final ConstrainedInteger n, final
 * ConstrainedInteger digits) { out.printf("%0" + digits.getValue() + "d\n",
 * n.getValue()); }
 * 
 * void printPaddedNumberHalfWidthSpace(final ConstrainedInteger n, final
 * ConstrainedInteger digits) { out.printf("%" + digits.getValue() + "d\n",
 * n.getValue()); }
 * 
 * }
 * 
 * final class IntRange { private final int minInclusive; private final int
 * maxExclusive;
 * 
 * public IntRange(final int minInclusive, final int maxExclusive) { if
 * (minInclusive >= maxExclusive) { throw new
 * IllegalArgumentException("最小値は最大値以下に指定してください。"); } this.minInclusive =
 * minInclusive; this.maxExclusive = maxExclusive; }
 * 
 * public void validate(final int value) { if (value < minInclusive) { throw new
 * IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。"); } if
 * (value >= maxExclusive) { throw new IllegalArgumentException("数値は " +
 * maxExclusive + " 未満で入力してください。"); } } }
 * 
 * final class ConstrainedInteger { private final int value; private final
 * IntRange constraint;
 * 
 * public ConstrainedInteger(final int value, final IntRange constraint) {
 * this.constraint = Objects.requireNonNull(constraint);
 * this.constraint.validate(value); this.value = value; }
 * 
 * public int getValue() { return value; }
 * 
 * }
 */