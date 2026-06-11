package exam.c148;

import valueobjects.ConstrainedInteger;

final class PlayerLevelCalculator {
    int calculateAfterBattles(final int initialPlayerLevel, final ConstrainedInteger[] enemyLevels) {
        final int[] playerLevelHistory = createPlayerLevelHistory(initialPlayerLevel, enemyLevels);
        
        return lastValueOf(playerLevelHistory);
    }

    private int[] createPlayerLevelHistory(
            final int initialPlayerLevel,
            final ConstrainedInteger[] enemyLevels) {

        final int[] playerLevelHistory = new int[enemyLevels.length + 1];
        playerLevelHistory[0] = initialPlayerLevel;

        for (int i = 0; i < enemyLevels.length; i++) {
            final int levelBeforeBattle = playerLevelHistory[i];
            final int enemyLevel = enemyLevels[i].getValue();
            playerLevelHistory[i + 1] = calculateAfterBattle(levelBeforeBattle, enemyLevel);
        }

        return playerLevelHistory;
    }

    private int lastValueOf(final int[] values) {
        return values[values.length - 1];
    }
    
    private int calculateAfterBattle(final int playerLevel, final int enemyLevel) {
        if (isPlayerWinner(playerLevel, enemyLevel)) {
            return levelAfterPlayerWins(playerLevel, enemyLevel);
        }

        if (isPlayerLoser(playerLevel, enemyLevel)) {
            return levelAfterPlayerLoses(playerLevel);
        }

        return playerLevel;
    }

    private boolean isPlayerWinner(final int playerLevel, final int enemyLevel) {
        return playerLevel > enemyLevel;
    }

    private boolean isPlayerLoser(final int playerLevel, final int enemyLevel) {
        return playerLevel < enemyLevel;
    }

    private int levelAfterPlayerWins(final int playerLevel, final int enemyLevel) {
        return playerLevel + enemyLevel / 2;
    }

    private int levelAfterPlayerLoses(final int playerLevel) {
        return playerLevel / 2;
    }
}
