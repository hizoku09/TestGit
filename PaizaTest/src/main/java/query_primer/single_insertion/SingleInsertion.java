package query_primer.single_insertion;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class SingleInsertion {
    public static void main(String[] args) {
        run(System.in, System.out);
    }

    static void run(final InputStream input, final PrintStream output) {
        try (Scanner sc = new Scanner(input)) {
            final SingleInsertionCalculator calculator = new SingleInsertionCalculator();
            final SingleInsertionPrinter printer = SingleInsertionPrinter.newInstance(output);
            final IntRange oneTo100_000 = new IntRange(1, 100000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final ConstrainedInteger k = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final IntRange zeroTo100 = new IntRange(0, 100);
            final ConstrainedInteger q = new ConstrainedInteger(sc.nextInt(), zeroTo100);
            final List<ConstrainedInteger> a = new ArrayList<ConstrainedInteger>();
            for (int i = 0; i < n.getValue(); i++) {
                a.add(new ConstrainedInteger(sc.nextInt(), zeroTo100));
            }

            final List<Integer> result = calculator.insertAt(a, k, q);
            printer.printSingleInsertion(result);
        }
    }

}
