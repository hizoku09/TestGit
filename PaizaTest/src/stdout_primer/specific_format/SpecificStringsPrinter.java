package stdout_primer.specific_format;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

class SpecificStringsPrinter {
    private final PrintStream out;

    SpecificStringsPrinter(final PrintStream out) {
        this.out = out;
    }

    void printConnectedStrings(final String s, final String t) {
        out.printf("%s + %s = %s\n", s, t, s + t);
    }

    void printIntegers2DpositionNtimes(final ConstrainedInteger n, final ConstrainedInteger x,
            final ConstrainedInteger y) {
        final int lasttime = n.getValue() - 1;

        for (int i = 0; i < n.getValue(); i++) {
            printIntegers2Dposition(x, y);
            if (i == lasttime) {
                out.println();
            } else {
                out.print(", ");
            }
        }
    }

    void printIntegers2Dposition(final ConstrainedInteger x, final ConstrainedInteger y) {
        out.printf("(%d, %d)", x.getValue(), y.getValue());
    }

    void printMultiplicationTables() {
        for (int i = 1; i <= 9; i++) {
            printMultiplicationLineOf(i);
            if (i != 9)
                printEqualLines();
        }
    }

    void printMultiplicationLineOf(final int i) {
        out.printf("%2d | %2d | %2d | %2d | %2d | %2d | %2d | %2d | %2d\n", i * 1, i * 2, i * 3, i * 4, i * 5, i * 6,
                i * 7, i * 8, i * 9);
    }

    void printEqualLines() {
        out.printf("==========================================\n");
    }

}
