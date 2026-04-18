package stdout_primer.print_width;

import java.io.PrintStream;

import valueobjects.ConstrainedIntegerObject;

class OutputWriter {
    private final PrintStream out;
    private static final int ConstrainedDigits = 3;

    OutputWriter(final PrintStream out) {
        this.out = out;
    }

    void printNaturalNumber3Digits(final ConstrainedIntegerObject naturalNumber) {
        // TODO 自動生成されたメソッド・スタブ
        final int N = naturalNumber.getValue();
        final int digits = String.valueOf(N).length();

        for (int i = 0; i < ConstrainedDigits - digits; i++) {
            out.print(" ");
        }
        out.printf("%d\n", N);
    }
    
    void printNaturalNumber3DigitsByZero(final ConstrainedIntegerObject naturalNumber) {
        // TODO 自動生成されたメソッド・スタブ
        final int N = naturalNumber.getValue();
        final int digits = String.valueOf(N).length();

        for (int i = 0; i < ConstrainedDigits - digits; i++) {
            out.printf("0");
        }
        out.printf("%d\n", N);
    }
}
