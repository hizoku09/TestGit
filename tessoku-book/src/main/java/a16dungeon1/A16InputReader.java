package a16dungeon1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

final class A16InputReader {
	private final Scanner scanner;

    private A16InputReader(final Scanner scanner) {
        this.scanner = scanner;
    }

    static A16InputReader newInstance(final Scanner scanner) {
        return new A16InputReader(scanner);
    }

    A16Input read() {
        final IntRange threeTo100_000 = new IntRange(3, 100_000);
        final IntRange oneTo100    = new IntRange(1, 100);
        final IntegerElementsN elementsN             = IntegerElementsN.newInstance(scanner.nextInt(), threeTo100_000);
        List<ConstrainedInteger> arrayA    = new ArrayList<ConstrainedInteger>();
        for (int i = 2; i <= elementsN.getValue(); i++) {
            arrayA.add(new ConstrainedInteger(scanner.nextInt(), oneTo100));
        }
        List<ConstrainedInteger> arrayB    = new ArrayList<ConstrainedInteger>();
        for (int i = 3; i <= elementsN.getValue(); i++) {
            arrayB.add(new ConstrainedInteger(scanner.nextInt(), oneTo100));
        }

        final A16Input result = A16Input.newInstance(elementsN, arrayA, arrayB);

        return result;
    }

}
