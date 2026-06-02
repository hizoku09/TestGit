package c_rank_exam.C097;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class C097 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final PrizewinnerPrinter printer = new PrizewinnerPrinter(System.out);
            final IntRange oneTo1000 = new IntRange(1, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger y = new ConstrainedInteger(sc.nextInt(), oneTo1000);

            printer.printPrizewinner(n, x, y);
        }
    }

}

//final class PrizewinnerPrinter {
//    private final PrintStream out;
//
//    public PrizewinnerPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    public void printPrizewinner(final ConstrainedInteger applicant, final ConstrainedInteger numberOfPresentA,
//            final ConstrainedInteger numberOfPresentB) {
//        for (int i = 1; i <= applicant.getValue(); i++) {
//            if (isMultipleOf(i, numberOfPresentA) && isMultipleOf(i, numberOfPresentB)) {
//                out.print("AB\n");
//            } else if (isMultipleOf(i, numberOfPresentA)) {
//                out.print("A\n");
//            } else if (isMultipleOf(i, numberOfPresentB)) {
//                out.print("B\n");
//            } else {
//                out.print("N\n");
//            }
//        }
//    }
//
//    private boolean isMultipleOf(final int n, final ConstrainedInteger multiple) {
//        return n % multiple.getValue() == 0;
//    }
//}
//
//final class IntRange {
//    private final int minInclusive;
//    private final int maxInclusive;
//
//    public IntRange(final int minInclusive, final int maxInclusive) {
//        if (minInclusive > maxInclusive) {
//            throw new IllegalArgumentException("最小値は最大値以下に指定してください。");
//        }
//        this.minInclusive = minInclusive;
//        this.maxInclusive = maxInclusive;
//    }
//
//    public void validate(final int value) {
//        if (value < minInclusive) {
//            throw new IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。");
//        }
//        if (value > maxInclusive) {
//            throw new IllegalArgumentException("数値は " + maxInclusive + " 以下で入力してください。");
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
//    public ConstrainedInteger add(final int other) {
//        final int added = this.value + other;
//        return new ConstrainedInteger(added, constraint);
//    }
//
//    public ConstrainedInteger subtract(final int other) {
//        // TODO 自動生成されたメソッド・スタブ
//        final int subtracted = this.value - other;
//        return new ConstrainedInteger(subtracted, constraint);
//    }
//
//    public ConstrainedInteger divide(final int other) {
//        final int divided = this.value / other;
//        return new ConstrainedInteger(divided, constraint);
//    }
//
//}
