package c_rank_exam;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class PlayerLevelPrinter {
    private final PrintStream out;

    PlayerLevelPrinter(final PrintStream out) {
        this.out = out;
    }

    void printPlayerLevelAfterBattle(final ConstrainedInteger playerLevel, final ConstrainedInteger[] enemyLevel) {
        int playerLevelAfterBattle = playerLevel.getValue();

        for (int i = 0; i < enemyLevel.length; i++) {
            if (isWin(playerLevelAfterBattle, enemyLevel[i].getValue())) {
                playerLevelAfterBattle = playerLevelUp(playerLevelAfterBattle, enemyLevel[i].getValue());
            } else if (playerLevelAfterBattle < enemyLevel[i].getValue()) {
                playerLevelAfterBattle = (playerLevelAfterBattle / 2);
            }
        }

        out.printf("%d", playerLevelAfterBattle);
    }

    private int playerLevelUp(int playerLevelAfterBattle, final int enemyLevel) {
        playerLevelAfterBattle += (enemyLevel / 2);
        return playerLevelAfterBattle;
    }

    private boolean isWin(final int playerLevelAfterBattle, final int enemyLevel) {
        return playerLevelAfterBattle > enemyLevel;
    }

}
