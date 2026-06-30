package query_primer.single_insertion;

import java.io.PrintStream;

final class SingleInsertionPrinter {
    private final PrintStream out;

    SingleInsertionPrinter(final PrintStream out) {
        this.out = out;
    }

    void printSingleInsertion(final int[] sourceValues) {
        printEachLine(sourceValues);
    }

    private void printEachLine(final int[] values) {
        for (final int value : values) {
            out.println(value);
        }
        
    }

}
