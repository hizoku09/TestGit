package stdout_primer.print_width;

import java.io.PrintStream;
import java.text.DecimalFormat;

import valueobjects.Constrained_integer_object;

class OutputWriter {
    private final PrintStream out;

    OutputWriter(final PrintStream out) {
        this.out = out;
    }

    void printNaturalNumber3Digits(final Constrained_integer_object naturalNumber) {
        // TODO 自動生成されたメソッド・スタブ
        final int N = naturalNumber.getValue();
        final int digits = String.valueOf(N).length();
        
        for () {
        
        }
        out.printf( + "f\n", N);
    }
}
