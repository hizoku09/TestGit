package query_primer.single_insertion;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class SingleInsertionPrinter {
    private final PrintStream out;

    SingleInsertionPrinter(final PrintStream out) {
        this.out = out;
    }

    void printSingleInsertion(final ConstrainedInteger order, ConstrainedInteger targetNumber, final ConstrainedInteger[] arrays) {
        final int[] results = new int[arrays.length + 1];
        
        for (int i = 0; i < order.getValue(); i++) {
            results[i] = arrays[i].getValue();
        }
        results[order.getValue()] = targetNumber.getValue();
        for(int j = order.getValue() + 1; j < arrays.length + 1; j++) {
            results[j] = arrays[j - 1].getValue();
        }
        
        for (final int result : results) {
            out.println(result);
        }
    }
}
