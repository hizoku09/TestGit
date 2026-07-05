package query_primer.single_insertion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

final class SingleInsertionInputReader {
    private final Scanner scanner;

    private SingleInsertionInputReader(final Scanner scanner) {
        this.scanner = scanner;
    }

    static SingleInsertionInputReader newInstance(final Scanner scanner) {
        return new SingleInsertionInputReader(scanner);
    }

    SingleInsertionInput read() {
        final IntRange oneTo100_000 = new IntRange(1, 100_000);
        final IntRange zeroTo100    = new IntRange(0, 100);
        final IntegerElementsN elementsN             = IntegerElementsN.newInstance(scanner.nextInt(), oneTo100_000);
        final IntegerInsertionIndexK insertionIndexK = IntegerInsertionIndexK.newInstance(scanner.nextInt(), oneTo100_000);
        final IntegerInsertionValueQ insertionValueQ = IntegerInsertionValueQ.newInstance(scanner.nextInt(), zeroTo100);
        List<ConstrainedInteger> sourceValues    = new ArrayList<ConstrainedInteger>();
        for (int i = 0; i < elementsN.getValue(); i++) {
            sourceValues.add(new ConstrainedInteger(scanner.nextInt(), zeroTo100));
        }

        final SingleInsertionInput result = SingleInsertionInput.newInstance(elementsN, insertionIndexK, insertionValueQ, sourceValues);

        return result;
    }
}
