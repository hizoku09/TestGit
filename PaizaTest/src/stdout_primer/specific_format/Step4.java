package stdout_primer.specific_format;

//import java.io.PrintStream;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Step4 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger h = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final ConstrainedInteger w = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final IntRange zeroTo9 = new IntRange(0, 9);
            final ConstrainedInteger a = new ConstrainedInteger(sc.nextInt(), zeroTo9);
            final ConstrainedInteger b = new ConstrainedInteger(sc.nextInt(), zeroTo9);

            final int lasttime = h.getValue() - 1;
            for (int i = 0; i < h.getValue(); i++) {
                printer.print2DpositionNtimesDelimiter(w, a, b);
                if (i != lasttime)
                    printer.printEqualLinesFor2Dposition(w.getValue());
            }
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
//    void print2DpositionNtimes(final ConstrainedInteger n, final ConstrainedInteger x, final ConstrainedInteger y) {
//        final int lasttime = n.getValue() - 1;
//
//        for (int i = 0; i < n.getValue(); i++) {
//            print2Dposition(x, y);
//            if (i == lasttime) {
//                out.println();
//            } else {
//                out.print(", ");
//            }
//        }
//    }
//
//    void print2Dposition(final ConstrainedInteger x, final ConstrainedInteger y) {
//        out.printf("(%d, %d)", x.getValue(), y.getValue());
//    }
//    
//    void print2DpositionNtimesDelimiter(final ConstrainedInteger n, final ConstrainedInteger x, final ConstrainedInteger y) {
//        final int lasttime = n.getValue() - 1;
//
//        for (int i = 0; i < n.getValue(); i++) {
//            print2Dposition(x, y);
//            if (i == lasttime) {
//                out.println();
//            } else {
//                printVerticalLineDelimiter();
//            }
//        }
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
//    void printMultiplicationLineOf(final int multiplicand) {
//        for (int j = 1; j <= 9; j++) {
//            out.printf("%2d", multiplicand * j);
//            if (j == 9)
//                out.println();
//            else
//                printVerticalLineDelimiter();
//        }
//    }
//
//    void printEqualLines() {
//        final int digitsOfProduct = 2;
//        final int verticalLine = 8;
//        final int paddedHalfWitdhSpace = 3;
//        for (int j = 0; j < digitsOfProduct * 9 + paddedHalfWitdhSpace * verticalLine; j++) {
//            out.print("=");
//        }
//        out.println();
//    }
//
//    void printEqualLinesStep4(final int numberOf2Dposition) {
//        final int digitsOfDelimiter = 3;
//        final int digitsOf2Dposition = 6;
//        final int neededEquals = digitsOf2Dposition * numberOf2Dposition + digitsOfDelimiter * (numberOf2Dposition - 1);
//        for (int i = 0; i < neededEquals; i++)
//            out.print("=");
//        out.println();
//    }
//
//    void printVerticalLineDelimiter() {
//        out.print(" | ");
//    }
//
//}

//
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
//
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
