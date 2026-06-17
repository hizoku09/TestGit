package query_primer.single_insertion;

import java.io.PrintStream;

import valueobjects.ConstrainedInteger;

final class SingleInsertionPrinter {
    private final PrintStream out;
    private final SingleInsertionCalculator calculator;
    
    SingleInsertionPrinter(final PrintStream out) {
        this.out = out;
        this.calculator = new SingleInsertionCalculator();
    }
    
    void printSingleInsertion(
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue,
            final ConstrainedInteger[] sourceValues) {

        final int[] insertedValues = calculator.insertAt(
                sourceValues,
                insertionIndex,
                insertionValue);

        printEachLine(insertedValues);
    }
    
    

    private void printEachLine(final int[] values) {
        for (final int value : values) {
            out.println(value);
        }
    }

}
