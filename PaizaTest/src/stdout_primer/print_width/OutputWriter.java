package stdout_primer.print_width;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

class OutputWriter {
    private final PrintStream out;
    private static final int ConstrainedDigits = 3;

    OutputWriter(final PrintStream out) {
        this.out = out;
    }

    void printNaturalNumber3Digits(final ConstrainedInteger naturalNumber) {
        final int N = naturalNumber.getValue();
        final int digits = String.valueOf(N).length();

        for (int i = 0; i < ConstrainedDigits - digits; i++) {
            out.print(" ");
        }
        out.printf("%d\n", N);
    }

    void printNaturalNumber3DigitsByZero(final ConstrainedInteger naturalNumber) {
        final int N = naturalNumber.getValue();
        final int digits = String.valueOf(N).length();

        for (int i = 0; i < ConstrainedDigits - digits; i++) {
            out.printf("0");
        }
        out.printf("%d\n", N);
    }

    void printNaturalNumberDigitsOf(final ConstrainedInteger naturalNumberN, final ConstrainedInteger naturalNumberM) {
        final int N = naturalNumberN.getValue();
        final int digits = String.valueOf(N).length();
        final int M = naturalNumberM.getValue();

        for (int i = 0; i < M - digits; i++) {
            out.print(" ");
        }

        out.printf("%d\n", N);
    }

    void printNaturalNumberArray(final ConstrainedInteger[] naturalNumberAi, final ConstrainedInteger naturalNumberM) {
        final int M = naturalNumberM.getValue();
        final int digits[] = new int[naturalNumberAi.length];
        for (int i = 0; i < naturalNumberAi.length; i++) {
            int Ai = naturalNumberAi[i].getValue();
            digits[i] = M - String.valueOf(Ai).length();
        }
        
        
        for (int i = 0; i < naturalNumberAi.length; i++) {
            printHalfWidthSpace(digits, i);
            out.printf("%d\n", naturalNumberAi[i].getValue());
        }
    }

    void printHalfWidthSpace(final int[] digits, int i) {
        for (int j = 0; j < digits[i]; j++)
            out.print(" ");
    }
    
}
