package c_rank_exam.C166;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class C166 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final AmountOfCoinsPrinter printer = new AmountOfCoinsPrinter(System.out);
            final IntRange oneTo1000 = new IntRange(1, 1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);

            printer.printCoinCountForPayment(x);
        }
    }

}

//final class CRankPrinter {
//
//    private final PrintStream out;
//
//    CRankPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printCoinCountForPayment(final ConstrainedInteger amountToPay) {
//        int amount = amountToPay.getValue();
//        int coin = 0;
//
//        while (amount > 0) {
//            if (amount >= 500) {
//                coin++;
//                amount -= 500;
//            } else if (amount >= 100) {
//                coin++;
//                amount -= 100;
//            } else if (amount >= 50) {
//                coin++;
//                amount -= 50;
//            } else if (amount >= 10) {
//                coin++;
//                amount -= 10;
//            } else if (amount >= 5) {
//                coin++;
//                amount -= 5;
//            } else if (amount >= 1) {
//                coin++;
//                amount -= 1;
//            }
//        }
//        
//        out.printf("%d", coin);
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
