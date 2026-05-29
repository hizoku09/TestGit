package c_rank_exam;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class AmountOfCoinsPrinter {

    private final PrintStream out;
    private static final int[] COIN_VALUES = {500, 100, 50, 10, 5, 1};

    AmountOfCoinsPrinter(final PrintStream out) {
        this.out = out;
    }

    void printCoinCountForPayment(final ConstrainedInteger amountToPay) {
        final int totalCoins = totalCoinCount(amountToPay.getValue(), COIN_VALUES);
        out.printf("%d", totalCoins);
    }

    private int totalCoinCount(final int amount, final int[] coinValues) {
        int totalCoinCount = 0;
        int remainingAmount = amount;

        for (final int coinValue : coinValues) {
            final int requiredCoins = remainingAmount / coinValue;
            final int paidByThisCoin = requiredCoins * coinValue;
            totalCoinCount += requiredCoins;
            remainingAmount -= paidByThisCoin;
        }
        
        return totalCoinCount;
    }
    
}
