package c_rank_exam;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class PlayerLevelPrinter {
    private final PrintStream out;

    PlayerLevelPrinter(final PrintStream out) {
        this.out = out;
    }

    void printPlayerLevelAfterBattle(final ConstrainedInteger playerLevel, final ConstrainedInteger[] enemyLevel) {
        final int length = enemyLevel.length;
        final ConstrainedInteger[] playerLevelBeforeBattle = new ConstrainedInteger[length];
        final ConstrainedInteger[] playerLevelAfterBattle = new ConstrainedInteger[length];
        playerLevelBeforeBattle[0] = playerLevel;
        
        for (int i = 0; i < length; i++) {
            if (isWin(playerLevelBeforeBattle[i], enemyLevel[i])) {
                playerLevelAfterBattle[i] = playerLevelUp(playerLevelBeforeBattle[i], enemyLevel[i]);
            } else if (isLose(playerLevelBeforeBattle[i], enemyLevel[i])) {
                playerLevelAfterBattle[i] = playerLevelDown(playerLevelBeforeBattle[i]);
            } else {
                playerLevelAfterBattle[i] = playerLevelBeforeBattle[i];
            }
            
            if (i != length - 1) {
                playerLevelBeforeBattle[i + 1] = playerLevelAfterBattle[i];
            }
        }

        out.printf("%d", playerLevelAfterBattle[length - 1].getValue());
    }

    private ConstrainedInteger playerLevelUp(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
        final ConstrainedInteger playerLevelAfterWin = playerLevel.add(enemyLevel.getValue() / 2);
        return playerLevelAfterWin;
    }
    
    private ConstrainedInteger playerLevelDown(final ConstrainedInteger playerLevel) {
        final ConstrainedInteger playerLevelAfterLose = playerLevel.divide(2);
        return playerLevelAfterLose;
    }

    private boolean isWin(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
        return playerLevel.getValue() > enemyLevel.getValue();
    }
    
    private boolean isLose(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
        return playerLevel.getValue() < enemyLevel.getValue();
    }

}
