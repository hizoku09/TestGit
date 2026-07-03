package query_primer.single_insertion;

import java.io.PrintStream;
import java.util.List;

final class SingleInsertionPrinter {
    private final PrintStream out;

    private SingleInsertionPrinter(final PrintStream out) {
        this.out = out;
    }
    
    static SingleInsertionPrinter newInstance(final PrintStream out) {
        return new SingleInsertionPrinter(out);
    }

    void printSingleInsertion(final List<Integer> sourceValues) {
        for (final Integer value : sourceValues) {
            out.println(value);
        }
    }

}
