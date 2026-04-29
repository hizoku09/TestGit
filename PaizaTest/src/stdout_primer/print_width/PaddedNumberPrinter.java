package stdout_primer.print_width;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

class PaddedNumberPrinter {
    private final PrintStream out;
    private static final int ConstrainedDigits = 3;

    PaddedNumberPrinter(final PrintStream out) {
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

    void printArrayPaddedHalfWidthSpace(final ConstrainedInteger[] array, final ConstrainedInteger digits) {
        final int paddingValue = digits.getValue();
        
        for (int i = 0; i < array.length; i++) {
            printHalfWidthSpace(array[i], paddingValue);
            out.printf("%d\n", array[i].getValue());
        }
    }
    
    void printHalfWidthSpace(final ConstrainedInteger n, final int paddingValue) {
        final int digitsOfn = String.valueOf(n.getValue()).length();
        final int paddingTimes = paddingValue - digitsOfn;
        
        for (int i = 0; i < paddingTimes; i++)
            out.print(" ");
    }
    
}
