package stdout_primer.specific_format;

import java.io.PrintStream;

class OutputWriter {
    private final PrintStream out;

    OutputWriter(final PrintStream out) {
        this.out = out;
    }

    void printConnectedStrings(final String s, final String t) {
        out.print(s + " + " + t + " = " + s + t);
    }
    
}
