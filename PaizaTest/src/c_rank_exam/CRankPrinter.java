package c_rank_exam;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class CRankPrinter {

    private final PrintStream out;

    CRankPrinter(final PrintStream out) {
        this.out = out;
    }

    void printCoinCountForPayment(final ConstrainedInteger amountToPay) {
        int amount = amountToPay.getValue();
        int coin = 0;

        while (amount > 0) {
            if (amount >= 500) {
                coin++;
                amount -= 500;
            } else if (amount >= 100) {
                coin++;
                amount -= 100;
            } else if (amount >= 50) {
                coin++;
                amount -= 50;
            } else if (amount >= 10) {
                coin++;
                amount -= 10;
            } else if (amount >= 5) {
                coin++;
                amount -= 5;
            } else if (amount >= 1) {
                coin++;
                amount -= 1;
            }
        }
        
        out.printf("%d", coin);
    }

}
