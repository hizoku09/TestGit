package exam.c148;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class PlayerLevelPrinter {
    private final PrintStream out;
    private static final int LevelUpConditionValue = 2;
    private static final int LevelDownConditionValue = 2;

    PlayerLevelPrinter(final PrintStream out) {
        this.out = out;
    }

    void printPlayerLevelAfterBattle(final ConstrainedInteger playerLevel, final ConstrainedInteger[] enemyLevel) {
        final int battleTimes = enemyLevel.length;
        final ConstrainedInteger[] playerLevelBeforeBattle = new ConstrainedInteger[battleTimes];
        final ConstrainedInteger[] playerLevelAfterBattle = new ConstrainedInteger[battleTimes];
        playerLevelBeforeBattle[0] = playerLevel;
        
        battleAndLevelUpOrDown(playerLevelBeforeBattle, enemyLevel, playerLevelAfterBattle, battleTimes);
        
        final int lastBattleTime = battleTimes - 1;
        final int playerLastLevel = playerLevelAfterBattle[lastBattleTime].getValue();
        out.printf("%d", playerLastLevel);
    }

    private void battleAndLevelUpOrDown(final ConstrainedInteger[] playerLevelBeforeBattle, final ConstrainedInteger[] enemyLevel,
            final ConstrainedInteger[] playerLevelAfterBattle, final int battleTimes) {
        final int lastBattleTime = battleTimes - 1;
        
        for (int i = 0; i < battleTimes; i++) {
            if (isWin(playerLevelBeforeBattle[i], enemyLevel[i])) {
                playerLevelAfterBattle[i] = playerLevelUp(playerLevelBeforeBattle[i], enemyLevel[i]);
            } else if (isLose(playerLevelBeforeBattle[i], enemyLevel[i])) {
                playerLevelAfterBattle[i] = playerLevelDown(playerLevelBeforeBattle[i]);
            } else {
                playerLevelAfterBattle[i] = playerLevelBeforeBattle[i];
            }
            
            if (i != lastBattleTime) {
                playerLevelBeforeBattle[i + 1] = playerLevelAfterBattle[i];
            }
        }
    }

    private ConstrainedInteger playerLevelUp(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
        final ConstrainedInteger playerLevelAfterWin = playerLevel.add(enemyLevel.getValue() / LevelUpConditionValue);
        return playerLevelAfterWin;
    }
    
    private ConstrainedInteger playerLevelDown(final ConstrainedInteger playerLevel) {
        final ConstrainedInteger playerLevelAfterLose = playerLevel.divide(LevelDownConditionValue);
        return playerLevelAfterLose;
    }

    private boolean isWin(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
        return playerLevel.getValue() > enemyLevel.getValue();
    }
    
    private boolean isLose(final ConstrainedInteger playerLevel, final ConstrainedInteger enemyLevel) {
        return playerLevel.getValue() < enemyLevel.getValue();
    }

}
