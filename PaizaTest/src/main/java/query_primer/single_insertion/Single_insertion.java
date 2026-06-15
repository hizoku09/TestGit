package query_primer.single_insertion;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Single_insertion {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final SingleInsertionPrinter printer = new SingleInsertionPrinter (System.out);
            final IntRange oneTo100000 = new IntRange(1, 100000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final ConstrainedInteger k = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final IntRange zeroTo100 = new IntRange(0, 100);
            final ConstrainedInteger q = new ConstrainedInteger(sc.nextInt(), zeroTo100);
            final ConstrainedInteger a[] = new ConstrainedInteger[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                a[i] = new ConstrainedInteger(sc.nextInt(), zeroTo100);
            }

            printer.printSingleInsertion(k, q, a);
        }
    }
}

//final class SingleInsertionPrinter {
//    private final PrintStream out;
//
//    SingleInsertionPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printSingleInsertion(final ConstrainedInteger order, ConstrainedInteger targetNumber, final ConstrainedInteger[] arrays) {
//        final int[] results = new int[arrays.length + 1];
//        
//        for (int i = 0; i < order.getValue(); i++) {
//            results[i] = arrays[i].getValue();
//        }
//        results[order.getValue()] = targetNumber.getValue();
//        for(int j = order.getValue() + 1; j < arrays.length + 1; j++) {
//            results[j] = arrays[j - 1].getValue();
//        }
//        
//        for (final int result : results) {
//            out.println(result);
//        }
//    }
//}
//
//final class IntRange {
//    final int minInclusive;
//    final int maxInclusive;
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
//}