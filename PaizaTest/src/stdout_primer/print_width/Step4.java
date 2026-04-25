package stdout_primer.print_width;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Step4 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final IntRange zeroTo999 = new IntRange(0, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), zeroTo999);
            final IntRange oneTo10 = new IntRange(1, 11);
            final ConstrainedInteger m = new ConstrainedInteger(sc.nextInt(), oneTo10);

            writer.printNaturalNumberDigitsOf(n, m);
        }
    }

}

/*
 * class OutputWriter { private final PrintStream out; private static final int
 * ConstrainedDigits = 3;
 * 
 * OutputWriter(final PrintStream out) { this.out = out; }
 * 
 * void printNaturalNumber3Digits(final ConstrainedInteger naturalNumber) {
 * final int N = naturalNumber.getValue(); final int digits =
 * String.valueOf(N).length();
 * 
 * for (int i = 0; i < ConstrainedDigits - digits; i++) { out.print(" "); }
 * out.printf("%d\n", N); }
 * 
 * void printNaturalNumber3DigitsByZero(final ConstrainedInteger naturalNumber)
 * { final int N = naturalNumber.getValue(); final int digits =
 * String.valueOf(N).length();
 * 
 * for (int i = 0; i < ConstrainedDigits - digits; i++) { out.printf("0"); }
 * out.printf("%d\n", N); }
 * 
 * void printNaturalNumberDigitsOf(final ConstrainedInteger naturalNumberN,
 * final ConstrainedInteger naturalNumberM) { final int N =
 * naturalNumberN.getValue(); final int digits = String.valueOf(N).length();
 * final int M = naturalNumberM.getValue();
 * 
 * for (int i = 0; i < M - digits; i++) { out.print(" "); }
 * 
 * out.printf("%d\n", N); } }
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