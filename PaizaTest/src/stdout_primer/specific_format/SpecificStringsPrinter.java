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

    void print2DpositionNtimes(final ConstrainedInteger n, final ConstrainedInteger x, final ConstrainedInteger y) {
        final int lasttime = n.getValue() - 1;

        for (int i = 0; i < n.getValue(); i++) {
            print2Dposition(x, y);
            if (i == lasttime) {
                out.println();
            } else {
                out.print(", ");
            }
        }
    }

    void print2Dposition(final ConstrainedInteger x, final ConstrainedInteger y) {
        out.printf("(%d, %d)", x.getValue(), y.getValue());
    }
    
    void print2DpositionNtimesDelimiter(final ConstrainedInteger n, final ConstrainedInteger x, final ConstrainedInteger y) {
        final int lasttime = n.getValue() - 1;

        for (int i = 0; i < n.getValue(); i++) {
            print2Dposition(x, y);
            if (i == lasttime) {
                out.println();
            } else {
                out.print(" | ");
            }
        }
    }

    void printMultiplicationTables() {
        for (int i = 1; i <= 9; i++) {
            printMultiplicationLineOf(i);
            if (i != 9)
                printEqualLines();
        }
    }

    void printMultiplicationLineOf(final int multiplicand) {
        for (int j = 1; j <= 9; j++) {
            out.printf("%2d", multiplicand * j);
            if (j == 9)
                out.println();
            else
                out.print(" | ");
        }
    }

    void printEqualLines() {
        final int digitsOfDelimiter = 3;
        final int digitsOfProduct = 2;
        final int neededEquals = digitsOfProduct * 9 + digitsOfDelimiter * (9 - 1);
        for (int j = 0; j < neededEquals; j++)
            out.print("=");
        out.println();
    }

    void printEqualLinesFor2Dposition(final int numberOf2Dposition) {
        final int digitsOfDelimiter = 3;
        final int digitsOf2Dposition = 6;
        final int neededEquals = digitsOf2Dposition * numberOf2Dposition + digitsOfDelimiter * (numberOf2Dposition - 1);
        for (int i = 0; i < neededEquals; i++)
            out.print("=");
        out.println();
    }
    
    void printPadded2DpositionNtimesDelimiter(final ConstrainedInteger n, final ConstrainedInteger x, final ConstrainedInteger y) {
        final int lasttime = n.getValue() - 1;

        for (int i = 0; i < n.getValue(); i++) {
            printPadded2Dposition(x, y);
            if (i == lasttime) {
                out.println();
            } else {
                out.print(" | ");
            }
        }
    }
    
    void printPadded2Dposition(final ConstrainedInteger x, final ConstrainedInteger y) {
        out.printf("(%9d, %9d)", x.getValue(), y.getValue());
    }
    
    void printEqualLinesForPadded2Dposition(final int numberOf2Dposition) {
        final int digitsOfDelimiter = 3;
        final int digitsOf2Dposition = 4 + 9 * 2;
        final int neededEquals = digitsOf2Dposition * numberOf2Dposition + digitsOfDelimiter * (numberOf2Dposition - 1);
        for (int i = 0; i < neededEquals; i++)
            out.print("=");
        out.println();
    }

}
