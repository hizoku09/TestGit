package stdout_primer.print_width;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Step3 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final IntRange zeroTo9999 = new IntRange(0, 10000);
            final ConstrainedInteger N = new ConstrainedInteger(sc.nextInt(), zeroTo9999);
            int M[] = new int[N.getValue()];
            for (int i = 0; i < N.getValue(); i++) {
                M[i] = sc.nextInt();
            }

            final IntRange zeroTo999 = new IntRange(0, 1000);
            for (int i = 0; i < N.getValue(); i++) {
                final ConstrainedInteger m = new ConstrainedInteger(M[i], zeroTo999);
                writer.printNaturalNumber3Digits(m);
            }
        }
    }

}

/*
 * class OutputWriter { private final PrintStream out; private static final int
 * ConstrainedDigits = 3;
 * 
 * OutputWriter(final PrintStream out) { this.out = out; }
 * 
 * void printNaturalNumber3Digits(final ConstrainedIntegerObject naturalNumber)
 * { // TODO 自動生成されたメソッド・スタブ final int N = naturalNumber.getValue(); final int
 * digits = String.valueOf(N).length();
 * 
 * for (int i = 0; i < ConstrainedDigits - digits; i++) { out.print(" "); }
 * out.printf("%d\n", N); }
 * 
 * void printNaturalNumber3DigitsByZero(final ConstrainedIntegerObject
 * naturalNumber) { // TODO 自動生成されたメソッド・スタブ final int N =
 * naturalNumber.getValue(); final int digits = String.valueOf(N).length();
 * 
 * for (int i = 0; i < ConstrainedDigits - digits; i++) { out.printf("0"); }
 * out.printf("%d\n", N); } }
 * 
 * interface IntConstraint { void validate(final int value); }
 * 
 * final class IntRange implements IntConstraint{ private final int
 * minInclusive; private final int maxExclusive;
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
 * final class ConstrainedIntegerObject { private final int value; private final
 * IntConstraint constraint;
 * 
 * public ConstrainedIntegerObject(final int value, final IntConstraint
 * constraint) { this.constraint = Objects.requireNonNull(constraint);
 * this.constraint.validate(value); this.value = value; }
 * 
 * public int getValue() { return value; }
 * 
 * }
 */