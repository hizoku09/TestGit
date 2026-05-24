package c_rank_skillcheck_sample;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class FizzBuzz {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final FizzBuzzPrinter printer = new FizzBuzzPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            
            for (int i = 1; i <= n.getValue(); i++)
                printer.printFizzBuzz(i);
        }
    }

}

//final class FizzBuzzPrinter {
//    private final PrintStream out;
//
//    FizzBuzzPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printFizzBuzz(final int n) {
//        if (isFizz(n) && isBuzz(n)) {
//            out.print("Fizz Buzz\n");
//        } else if (isFizz(n)) {
//            out.print("Fizz\n");
//        } else if (isBuzz(n)) {
//            out.print("Buzz\n");
//        } else {
//            out.printf("%d\n", n);
//        }
//    }
//
//    boolean isBuzz(final int n) {
//        final int buzz = n % 5;
//        return buzz == 0;
//    }
//
//    boolean isFizz(final int n) {
//        final int fizz = n % 3;
//        return fizz == 0;
//    }
//
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
//}
