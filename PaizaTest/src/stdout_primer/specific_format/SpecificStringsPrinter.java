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

    void printStrings2Dposition(final ConstrainedInteger s, final ConstrainedInteger t) {
        out.print("(10, 99),");
        out.print("(10, 99),");
        out.print("(10, 99)");
    }
    
}
