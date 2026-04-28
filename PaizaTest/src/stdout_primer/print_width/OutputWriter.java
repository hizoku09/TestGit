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

    void printNaturalNumberArraySpaceDelimited(final ConstrainedInteger[] arrayAi, final ConstrainedInteger digits) {
        final int valueOfDigits = digits.getValue();
        
        for (int i = 0; i < arrayAi.length; i++) {
            printHalfWidthSpace(arrayAi[i], valueOfDigits);
            out.printf("%d\n", arrayAi[i].getValue());
        }
    }
    
    void printHalfWidthSpace(final ConstrainedInteger naturalNumber, final int valueOfDigits) {
        final int value = naturalNumber.getValue();
        final int numberOfHalWidthSpace = valueOfDigits - String.valueOf(value).length();
        for (int i = 0; i < numberOfHalWidthSpace; i++)
            out.print(" ");
    }
    
}
