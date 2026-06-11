package exam.c148;

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
//    private final PlayerLevelCalculator calculator;
//
//    PlayerLevelPrinter(final PrintStream out) {
//        this.out = out;
//        this.calculator = new PlayerLevelCalculator();
//    }
//
//    void printPlayerLevelAfterBattle(
//            final ConstrainedInteger playerLevel, 
//            final ConstrainedInteger[] enemyLevels) {
//        final int finalPlayerLevel = 
//                calculator.calculateAfterBattles(playerLevel.getValue(), enemyLevels);
//
//        out.printf("%d", finalPlayerLevel);
//    }
//}
//
//final class PlayerLevelCalculator {
//    int calculateAfterBattles(final int initialPlayerLevel, final ConstrainedInteger[] enemyLevels) {
//        final int[] playerLevelHistory = createPlayerLevelHistory(initialPlayerLevel, enemyLevels);
//        
//        return lastValueOf(playerLevelHistory);
//    }
//
//    private int[] createPlayerLevelHistory(
//            final int initialPlayerLevel,
//            final ConstrainedInteger[] enemyLevels) {
//
//        final int[] playerLevelHistory = new int[enemyLevels.length + 1];
//        playerLevelHistory[0] = initialPlayerLevel;
//
//        for (int i = 0; i < enemyLevels.length; i++) {
//            final int levelBeforeBattle = playerLevelHistory[i];
//            final int enemyLevel = enemyLevels[i].getValue();
//            playerLevelHistory[i + 1] = calculateAfterBattle(levelBeforeBattle, enemyLevel);
//        }
//
//        return playerLevelHistory;
//    }
//
//    private int lastValueOf(final int[] values) {
//        return values[values.length - 1];
//    }
//    
//    private int calculateAfterBattle(final int playerLevel, final int enemyLevel) {
//        if (isPlayerWinner(playerLevel, enemyLevel)) {
//            return levelAfterPlayerWins(playerLevel, enemyLevel);
//        }
//
//        if (isPlayerLoser(playerLevel, enemyLevel)) {
//            return levelAfterPlayerLoses(playerLevel);
//        }
//
//        return playerLevel;
//    }
//
//    private boolean isPlayerWinner(final int playerLevel, final int enemyLevel) {
//        return playerLevel > enemyLevel;
//    }
//
//    private boolean isPlayerLoser(final int playerLevel, final int enemyLevel) {
//        return playerLevel < enemyLevel;
//    }
//
//    private int levelAfterPlayerWins(final int playerLevel, final int enemyLevel) {
//        return playerLevel + enemyLevel / 2;
//    }
//
//    private int levelAfterPlayerLoses(final int playerLevel) {
//        return playerLevel / 2;
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
