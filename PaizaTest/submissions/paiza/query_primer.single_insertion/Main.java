import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
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

final class SingleInsertionCalculator {
    List<Integer> insertAt(
            final List<ConstrainedInteger> sourceValues,
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue) {

        final List<Integer> result = new ArrayList<Integer>();
        
        validateInsertionIndex(insertionIndex, sourceValues.size());
        for (ConstrainedInteger original : sourceValues) {
            result.add(original.getValue());
        }
        result.add(insertionIndex.getValue(), insertionValue.getValue());

        return result;
    }
    
    private void validateInsertionIndex(
            final ConstrainedInteger insertionIndex,
            final int sourceLength) {

        if (insertionIndex.getValue() < 0 || insertionIndex.getValue() > sourceLength) {
            throw new IllegalArgumentException(
                    "挿入位置は 0 以上 " + sourceLength + " 以下で指定してください。");
        }
    }
}

final class SingleInsertionPrinter {
    private final PrintStream out;

    private SingleInsertionPrinter(final PrintStream out) {
        this.out = out;
    }
    
    public static SingleInsertionPrinter newInstance(final PrintStream out) {
        return new SingleInsertionPrinter(out);
    }

    void printSingleInsertion(final List<Integer> sourceValues) {
        for (final Integer value : sourceValues) {
            out.println(value);
        }
    }

}

final class IntRange {
    private final int minInclusive;
    private final int maxInclusive;

    public IntRange(final int minInclusive, final int maxInclusive) {
        if (minInclusive > maxInclusive) {
            throw new IllegalArgumentException("最小値は最大値以下に指定してください。");
        }
        this.minInclusive = minInclusive;
        this.maxInclusive = maxInclusive;
    }

    public void validate(final int value) {
        if (value < minInclusive) {
            throw new IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。");
        }
        if (value > maxInclusive) {
            throw new IllegalArgumentException("数値は " + maxInclusive + " 以下で入力してください。");
        }
    }
}

final class ConstrainedInteger {
    private final int value;
    private final IntRange constraint;

    public ConstrainedInteger(final int value, final IntRange constraint) {
        this.constraint = Objects.requireNonNull(constraint);
        this.constraint.validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
