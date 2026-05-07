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
        out.printf(" %d |  %d |  %d |  %d |  %d |  %d |  %d |  %d |  %d\n", 1, 2, 3, 4, 5, 6, 7, 8, 9);
//                    + "==========================================\n"
//                    + " 2 |  4 |  6 |  8 | 10 | 12 | 14 | 16 | 18\n" + "==========================================\n"
//                    + " 3 |  6 |  9 | 12 | 15 | 18 | 21 | 24 | 27\n" + "==========================================\n"
//                    + " 4 |  8 | 12 | 16 | 20 | 24 | 28 | 32 | 36\n" + "==========================================\n"
//                    + " 5 | 10 | 15 | 20 | 25 | 30 | 35 | 40 | 45\n" + "==========================================\n"
//                    + " 6 | 12 | 18 | 24 | 30 | 36 | 42 | 48 | 54\n" + "==========================================\n"
//                    + " 7 | 14 | 21 | 28 | 35 | 42 | 49 | 56 | 63\n" + "==========================================\n"
//                    + " 8 | 16 | 24 | 32 | 40 | 48 | 56 | 64 | 72\n" + "==========================================\n"
//                    + " 9 | 18 | 27 | 36 | 45 | 54 | 63 | 72 | 81"
    }

}
