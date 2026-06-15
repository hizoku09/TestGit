package query_primer.single_insertion;

import java.io.PrintStream;

class SingleInsertionPrinter {
    private final PrintStream out;

    SingleInsertionPrinter(final PrintStream out) {
        this.out = out;
    }

    void printSingleInsertion(final String targetWord, final String[] checkLines) {
        for (final String line : checkLines) {
            if (line.contains(targetWord))
                out.println("Yes");
            else {
                out.println("No");
            }
        }
    }
}
