package stdout_primer.specific_format;

import java.io.PrintStream;

class SpecificStringsOutput {
    private final PrintStream out;

    SpecificStringsOutput(final PrintStream out) {
        this.out = out;
    }

    void printConnectedStrings(final String s, final String t) {
        out.printf("%s + %s = %s\n", s, t, s + t);
    }
    
}
