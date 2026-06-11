package exam.c148;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class PlayerLevelPrinter {
    private final PrintStream out;
    private final PlayerLevelCalculator calculator;

    PlayerLevelPrinter(final PrintStream out) {
        this.out = out;
        this.calculator = new PlayerLevelCalculator();
    }

    void printPlayerLevelAfterBattle(
            final ConstrainedInteger playerLevel, 
            final ConstrainedInteger[] enemyLevels) {
        final int finalPlayerLevel = 
                calculator.calculateAfterBattles(playerLevel.getValue(), enemyLevels);

        out.printf("%d", finalPlayerLevel);
    }
}
