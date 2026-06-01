package c_rank_exam;

import java.io.PrintStream;

final class RockPaperScissorsResultPrinter {
    private final PrintStream out;

    RockPaperScissorsResultPrinter(final PrintStream out) {
        this.out = out;
    }

    void printWinTimesOfRockPaperScissors(final String[] playerChoices, final String[] enemyChoices) {
        final int battleTimes = playerChoices.length;
        final int winTimesOfPlayer = countWinTimesOfPlayer(playerChoices, enemyChoices, battleTimes);
        
        out.printf("%d", winTimesOfPlayer);
    }

    private int countWinTimesOfPlayer(final String[] playerChoices, final String[] enemyChoices, final int battleTimes) {
        int result = 0;
        
        for (int i = 0; i < battleTimes; i++) {
            if (isWin(playerChoices[i], enemyChoices[i]))
                result++;
        }
        
        return result;
    }

    private boolean isWin(final String playerChoice, final String enemyChoice) {
        if (playerChoice.equals("G") && enemyChoice.equals("C"))
            return true;
        if (playerChoice.equals("C") && enemyChoice.equals("P"))
            return true;
        if (playerChoice.equals("P") && enemyChoice.equals("G"))
            return true;
        return false;
    }
}
