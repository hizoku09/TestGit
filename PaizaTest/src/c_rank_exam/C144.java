package c_rank_exam;

import java.util.Scanner;
//import java.io.PrintStream;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class C144 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final RockPaperScissorsResultPrinter printer = new RockPaperScissorsResultPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final String choiceOfAlice[] = new String[n.getValue()];
            final String choiceOfBob[] = new String[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                choiceOfAlice[i] = sc.next();
                choiceOfBob[i] = sc.next();
            }

            printer.printWinTimesOfRockPaperScissors(choiceOfAlice, choiceOfBob);
        }
    }
    
}

//final class RockPaperScissorsResultPrinter {
//    private final PrintStream out;
//
//    RockPaperScissorsResultPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printWinTimesOfRockPaperScissors(final String[] playerChoices, final String[] enemyChoices) {
//        final int battleTimes = playerChoices.length;
//        final int winTimesOfPlayer = countWinTimesOfPlayer(playerChoices, enemyChoices, battleTimes);
//
//        out.printf("%d", winTimesOfPlayer);
//    }
//
//    private int countWinTimesOfPlayer(final String[] playerChoices, final String[] enemyChoices,
//            final int battleTimes) {
//        int result = 0;
//
//        for (int i = 0; i < battleTimes; i++) {
//            if (isWin(playerChoices[i], enemyChoices[i]))
//                result++;
//        }
//
//        return result;
//    }
//
//    private boolean isWin(final String playerChoice, final String enemyChoice) {
//        if (playerChoice.equals("G") && enemyChoice.equals("C"))
//            return true;
//        if (playerChoice.equals("C") && enemyChoice.equals("P"))
//            return true;
//        if (playerChoice.equals("P") && enemyChoice.equals("G"))
//            return true;
//        return false;
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
