package c_rank_exam.C144;

import java.io.PrintStream;

final class RockPaperScissorsResultPrinter {
    private final PrintStream out;
    private static final String rock = "G";
    private static final String scissors = "C";
    private static final String paper = "P";

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
        if (playerChoice.equals(rock) && enemyChoice.equals(scissors))
            return true;
        if (playerChoice.equals(scissors) && enemyChoice.equals(paper))
            return true;
        if (playerChoice.equals(paper) && enemyChoice.equals(rock))
            return true;
        return false;
    }
}
