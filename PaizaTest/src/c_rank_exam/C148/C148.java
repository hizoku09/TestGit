package c_rank_exam.C148;

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
//    private static final int LevelUpConditionValue = 2;
//    private static final int LevelDownConditionValue = 2;
//
//    PlayerLevelPrinter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printPlayerLevelAfterBattle(final ConstrainedInteger playerLevel, final ConstrainedInteger[] enemyLevel) {
//        final int battleTimes = enemyLevel.length;
//        final ConstrainedInteger[] playerLevelBeforeBattle = new ConstrainedInteger[battleTimes];
//        final ConstrainedInteger[] playerLevelAfterBattle = new ConstrainedInteger[battleTimes];
//        playerLevelBeforeBattle[0] = playerLevel;
//
//        battleAndLevelUpOrDown(playerLevelBeforeBattle, enemyLevel, playerLevelAfterBattle, battleTimes);
//
//        final int lastBattleTime = battleTimes - 1;
//        final int playerLastLevel = playerLevelAfterBattle[lastBattleTime].getValue();
//        out.printf("%d", playerLastLevel);
//    }
//
//    private void battleAndLevelUpOrDown(final ConstrainedInteger[] playerLevelBeforeBattle,
//            final ConstrainedInteger[] enemyLevel, final ConstrainedInteger[] playerLevelAfterBattle,
//            final int battleTimes) {
//        final int lastBattleTime = battleTimes - 1;
//
//        for (int i = 0; i < battleTimes; i++) {
//            if (isWin(playerLevelBeforeBattle[i], enemyLevel[i])) {
//                playerLevelAfterBattle[i] = playerLevelUp(playerLevelBeforeBattle[i], enemyLevel[i]);
//            } else if (isLose(playerLevelBeforeBattle[i], enemyLevel[i])) {
//                playerLevelAfterBattle[i] = playerLevelDown(playerLevelBeforeBattle[i]);
//            } else {
//                playerLevelAfterBattle[i] = playerLevelBeforeBattle[i];
//            }
//
//            if (i != lastBattleTime) {
//                playerLevelBeforeBattle[i + 1] = playerLevelAfterBattle[i];
//            }
//        }
//    }
//
//    private ConstrainedInteger playerLevelUp(final ConstrainedInteger playerLevel,
//            final ConstrainedInteger enemyLevel) {
//        final ConstrainedInteger playerLevelAfterWin = playerLevel.add(enemyLevel.getValue() / LevelUpConditionValue);
//        return playerLevelAfterWin;
//    }
//
//    private ConstrainedInteger playerLevelDown(final ConstrainedInteger playerLevel) {
//        final ConstrainedInteger playerLevelAfterLose = playerLevel.divide(LevelDownConditionValue);
//        return playerLevelAfterLose;
//    }
//
//    private boolean isWin(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
//        return playerLevel.getValue() > enemyLevel.getValue();
//    }
//
//    private boolean isLose(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
//        return playerLevel.getValue() < enemyLevel.getValue();
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
