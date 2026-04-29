package stdout_primer.print_width;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Boss {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final PaddedNumberPrinter writer = new PaddedNumberPrinter(System.out);
            
            final IntRange oneTo99 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo99);
            final IntRange oneTo10 = new IntRange(1, 11);
            final ConstrainedInteger m = new ConstrainedInteger(sc.nextInt(), oneTo10);
            final IntRange zeroTo999 = new IntRange(0, 1000);
            final int length = n.getValue();
            final ConstrainedInteger ai[] = new ConstrainedInteger[length];
            for (int i = 0; i < length; i++) {
                ai[i] = new ConstrainedInteger(sc.nextInt(), zeroTo999);
                
            }

            writer.printArrayPaddedHalfWidthSpace(ai, m);
        }
    }

}

//class PaddedNumberPrinter {
//    private final PrintStream out;
//    private static final int ConstrainedDigits = 3;
//
//    PaddedNumberPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printNaturalNumber3Digits(final ConstrainedInteger naturalNumber) {
//        final int N = naturalNumber.getValue();
//        final int digits = String.valueOf(N).length();
//
//        for (int i = 0; i < ConstrainedDigits - digits; i++) {
//            out.print(" ");
//        }
//        out.printf("%d\n", N);
//    }
//
//    void printNaturalNumber3DigitsByZero(final ConstrainedInteger naturalNumber) {
//        final int N = naturalNumber.getValue();
//        final int digits = String.valueOf(N).length();
//
//        for (int i = 0; i < ConstrainedDigits - digits; i++) {
//            out.printf("0");
//        }
//        out.printf("%d\n", N);
//    }
//
//    void printNaturalNumberDigitsOf(final ConstrainedInteger naturalNumberN, final ConstrainedInteger naturalNumberM) {
//        final int N = naturalNumberN.getValue();
//        final int digits = String.valueOf(N).length();
//        final int M = naturalNumberM.getValue();
//
//        for (int i = 0; i < M - digits; i++) {
//            out.print(" ");
//        }
//
//        out.printf("%d\n", N);
//    }
//
//    void printArrayPaddedHalfWidthSpace(final ConstrainedInteger[] array, final ConstrainedInteger digits) {
//        final int paddingValue = digits.getValue();
//        
//        for (int i = 0; i < array.length; i++) {
//            printHalfWidthSpace(array[i], paddingValue);
//            out.printf("%d\n", array[i].getValue());
//        }
//    }
//    
//    void printHalfWidthSpace(final ConstrainedInteger n, final int paddingValue) {
//        final int digitsOfn = String.valueOf(n.getValue()).length();
//        final int paddingTimes = paddingValue - digitsOfn;
//        
//        for (int i = 0; i < paddingTimes; i++)
//            out.print(" ");
//    }
//    
//}
//
//final class IntRange {
//    private final int minInclusive;
//    private final int maxExclusive;
//
//    public IntRange(final int minInclusive, final int maxExclusive) {
//        if (minInclusive >= maxExclusive) {
//            throw new IllegalArgumentException("最小値は最大値以下に指定してください。");
//        }
//        this.minInclusive = minInclusive;
//        this.maxExclusive = maxExclusive;
//    }
//
//    public void validate(final int value) {
//        if (value < minInclusive) {
//            throw new IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。");
//        }
//        if (value >= maxExclusive) {
//            throw new IllegalArgumentException("数値は " + maxExclusive + " 未満で入力してください。");
//        }
//    }
//}
//
//final class ConstrainedInteger {
//    private final int value;
//    private final IntRange constraint;
//
//    public ConstrainedInteger(final int value, final IntRange constraint) {
//        this.constraint = Objects.requireNonNull(constraint);
//        this.constraint.validate(value);
//        this.value = value;
//    }
//
//    public int getValue() {
//        return value;
//    }
//    
//}