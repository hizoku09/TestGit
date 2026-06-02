package c_rank_exam.C097;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class PrizewinnerPrinter {
    private final PrintStream out;

    PrizewinnerPrinter(final PrintStream out) {
        this.out = out;
    }

    void printPrizewinner(final ConstrainedInteger applicant, 
            final ConstrainedInteger numberOfPresentA, final ConstrainedInteger numberOfPresentB) {
        for (int i = 1; i <= applicant.getValue(); i++) {
            if (isMultipleOf(i, numberOfPresentA) && isMultipleOf(i, numberOfPresentB)) {
                out.print("AB\n");
            } else if (isMultipleOf(i, numberOfPresentA)) {
                out.print("A\n");
            } else if (isMultipleOf(i, numberOfPresentB)) {
                out.print("B\n");
            } else {
                out.print("N\n");
            }
        }
    }

    private boolean isMultipleOf(final int n, final ConstrainedInteger multiple) {
        return n % multiple.getValue() == 0;
    }
}
