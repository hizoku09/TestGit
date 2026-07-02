package query_primer.single_insertion;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

final class SingleInsertionFetcher {
    private final InputStream in;

    private SingleInsertionFetcher(final InputStream in) {
        this.in = in;
    }

    public static SingleInsertionFetcher newInstance(final InputStream in) {
        return new SingleInsertionFetcher(in);
    }

    List<ConstrainedInteger> fetch() {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(in)) {
            final IntRange oneTo100_000 = new IntRange(1, 100_000);
            final ConstrainedInteger elementsN = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final ConstrainedInteger insertionIndexK = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final IntRange zeroTo100 = new IntRange(0, 100);
            final ConstrainedInteger insertionValueQ = new ConstrainedInteger(sc.nextInt(), zeroTo100);

            List<ConstrainedInteger> list = new ArrayList<ConstrainedInteger>();
            list.add(elementsN);
            list.add(insertionIndexK);
            list.add(insertionValueQ);
            final List<ConstrainedInteger> result = Collections.unmodifiableList(list);

            return result;
        }
    }
}
