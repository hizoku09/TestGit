package stdout_primer.print_width;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

class PaddedNumberPrinter {
    private final PrintStream out;

    PaddedNumberPrinter(final PrintStream out) {
        this.out = out;
    }

    void printPaddedNumberZero(final ConstrainedInteger n, final ConstrainedInteger digits) {
        out.printf("%0" + digits.getValue() + "d\n", n.getValue());
    }

    void printPaddedNumberHalfWidthSpace(final ConstrainedInteger n, final ConstrainedInteger digits) {
        out.printf("%" + digits.getValue() + "d\n", n.getValue());
    }
    
}
