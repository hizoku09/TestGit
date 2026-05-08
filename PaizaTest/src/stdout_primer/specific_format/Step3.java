package stdout_primer.specific_format;

import java.util.Scanner;
//import java.io.PrintStream;

class Step3 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);

            printer.printMultiplicationTables();
        }
    }

}

//class SpecificStringsPrinter {
//    private final PrintStream out;
//
//    SpecificStringsPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printConnectedStrings(final String s, final String t) {
//        out.printf("%s + %s = %s\n", s, t, s + t);
//    }
//
//    void printIntegers2DpositionNtimes(final ConstrainedInteger n, final ConstrainedInteger x,
//            final ConstrainedInteger y) {
//        final int lasttime = n.getValue() - 1;
//
//        for (int i = 0; i < n.getValue(); i++) {
//            printIntegers2Dposition(x, y);
//            if (i == lasttime) {
//                out.println();
//            } else {
//                out.print(", ");
//            }
//        }
//    }
//
//    void printIntegers2Dposition(final ConstrainedInteger x, final ConstrainedInteger y) {
//        out.printf("(%d, %d)", x.getValue(), y.getValue());
//    }
//
//    void printMultiplicationTables() {
//        for (int i = 1; i <= 9; i++) {
//            printMultiplicationLineOf(i);
//            if (i != 9)
//                printEqualLines();
//        }
//    }
//
//    void printMultiplicationLineOf(final int i) {
//        out.printf("%2d | %2d | %2d | %2d | %2d | %2d | %2d | %2d | %2d\n", i * 1, i * 2, i * 3, i * 4, i * 5, i * 6,
//                i * 7, i * 8, i * 9);
//    }
//
//    void printEqualLines() {
//        out.printf("==========================================\n");
//    }
//
//}

//final class IntRange {
//private final int minInclusive;
//private final int maxInclusive;
//
//public IntRange(final int minInclusive, final int maxInclusive) {
//  if (minInclusive > maxInclusive) {
//      throw new IllegalArgumentException("最小値は最大値以下に指定してください。");
//  }
//  this.minInclusive = minInclusive;
//  this.maxInclusive = maxInclusive;
//}
//
//public void validate(final int value) {
//  if (value < minInclusive) {
//      throw new IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。");
//  }
//  if (value > maxInclusive) {
//      throw new IllegalArgumentException("数値は " + maxInclusive + " 以下で入力してください。");
//  }
//}
//}

//final class ConstrainedInteger {
//private final int value;
//private final IntRange constraint;
//
//public ConstrainedInteger(final int value, final IntRange constraint) {
//  this.constraint = Objects.requireNonNull(constraint);
//  this.constraint.validate(value);
//  this.value = value;
//}
//
//public int getValue() {
//  return value;
//}
//
//}
