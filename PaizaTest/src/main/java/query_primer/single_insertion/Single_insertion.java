package query_primer.single_insertion;

import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

class Single_insertion {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final SingleInsertionPrinter printer = new SingleInsertionPrinter (System.out);
            final IntRange oneTo100000 = new IntRange(1, 100000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final ConstrainedInteger k = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger q = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final ConstrainedInteger a[] = new ConstrainedInteger[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                a[i] = new ConstrainedInteger(sc.nextInt(), oneTo100);
            }

            printer.printSingleInsertion();
        }
    }
}
