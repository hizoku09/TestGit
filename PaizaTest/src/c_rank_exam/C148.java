package c_rank_exam;

//import java.io.PrintStream;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class C148 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final PlayerLevelPrinter printer = new PlayerLevelPrinter(System.out);
            final IntRange oneTo100000 = new IntRange(1, 100000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final IntRange oneTo10000 = new IntRange(1, 10000);
            final ConstrainedInteger l = new ConstrainedInteger(sc.nextInt(), oneTo10000);
            final ConstrainedInteger x[] = new ConstrainedInteger[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                 x[i] = new ConstrainedInteger(sc.nextInt(), oneTo10000);
            }

            printer.printPlayerLevelAfterBattle(l, x);
        }
    }

}

//final class PlayerLevelPrinter {
//    private final PrintStream out;
//
//    PlayerLevelPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printPlayerLevelAfterBattle(final ConstrainedInteger playerLevel, final ConstrainedInteger[] enemyLevel) {
//        int playerLevelAfterBattle = playerLevel.getValue();
//
//        for (int i = 0; i < enemyLevel.length; i++) {
//            if (playerLevelAfterBattle > enemyLevel[i].getValue()) {
//                playerLevelAfterBattle += (enemyLevel[i].getValue() / 2);
//            } else if (playerLevelAfterBattle < enemyLevel[i].getValue()) {
//                playerLevelAfterBattle = (playerLevelAfterBattle / 2);
//            }
//        }
//
//        out.printf("%d", playerLevelAfterBattle);
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
