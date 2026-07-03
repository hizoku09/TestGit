import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
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
            final SingleInsertionFetcher    fetcher    = SingleInsertionFetcher.newInstance(input);
            final SingleInsertionInput      fetched    = fetcher.fetch();
            final SingleInsertionCalculator calculator = SingleInsertionCalculator.getInstance();
            final SingleInsertionPrinter    printer    = SingleInsertionPrinter.newInstance(output);
            
            final List<Integer> result = calculator.insertAt(
                    fetched.sourceValues(),
                    fetched.insertionIndexK(),
                    fetched.insertionValueQ());

            printer.printSingleInsertion(result);
        }
    }

}

final class SingleInsertionCalculator {
    private static final SingleInsertionCalculator INSTANCE = new SingleInsertionCalculator();
    private SingleInsertionCalculator() {
        // TODO 自動生成されたコンストラクター・スタブ
    }
    
    static SingleInsertionCalculator getInstance() {
        return INSTANCE;
    }
    
    List<Integer> insertAt(
            final List<ConstrainedInteger> sourceValues,
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue) {

        final List<Integer> convertInteger = new ArrayList<>();
        
        validateInsertionIndex(insertionIndex, sourceValues.size());
        for (ConstrainedInteger original : sourceValues) {
            convertInteger.add(original.getValue());
        }
        convertInteger.add(insertionIndex.getValue(), insertionValue.getValue());
        final List<Integer> result = Collections.unmodifiableList(convertInteger);

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

final class SingleInsertionFetcher {
    private final InputStream in;

    private SingleInsertionFetcher(final InputStream in) {
        this.in = in;
    }

    static SingleInsertionFetcher newInstance(final InputStream in) {
        return new SingleInsertionFetcher(in);
    }

    SingleInsertionInput fetch() {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(in)) {
            final IntRange oneTo100_000 = new IntRange(1, 100_000);
            final IntRange zeroTo100    = new IntRange(0, 100);
            final ConstrainedInteger elementsN       = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final ConstrainedInteger insertionIndexK = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final ConstrainedInteger insertionValueQ = new ConstrainedInteger(sc.nextInt(), zeroTo100);
            List<ConstrainedInteger> sourceValues = new ArrayList<ConstrainedInteger>();
            for (int i = 0; i < elementsN.getValue(); i++) {
                sourceValues.add(new ConstrainedInteger(sc.nextInt(), zeroTo100));
            }
            
            sourceValues = Collections.unmodifiableList(sourceValues);
            final SingleInsertionInput result = SingleInsertionInput.newInstance(elementsN, insertionIndexK, insertionValueQ, sourceValues);
            
            return result;
        }
    }
}

final class SingleInsertionInput {
    private final ConstrainedInteger elementsN;
    private final ConstrainedInteger insertionIndexK;
    private final ConstrainedInteger insertionValueQ;
    private final List<ConstrainedInteger> sourceValues;
    
    private SingleInsertionInput(
            final ConstrainedInteger elementsN, 
            final ConstrainedInteger insertionIndexK, 
            final ConstrainedInteger insertionValueQ,
            final List<ConstrainedInteger> sourceValues) {
        
        this.elementsN       = elementsN;
        this.insertionIndexK = insertionIndexK;
        this.insertionValueQ = insertionValueQ;
        this.sourceValues    = List.copyOf(sourceValues);;
    }

    static SingleInsertionInput newInstance(
            final ConstrainedInteger elementsN, 
            final ConstrainedInteger insertionIndexK, 
            final ConstrainedInteger insertionValueQ,
            final List<ConstrainedInteger> sourceValues) {
        
        return new SingleInsertionInput(elementsN, insertionIndexK, insertionValueQ, sourceValues);
    }

    ConstrainedInteger elementsN() {
        // TODO 自動生成されたメソッド・スタブ
        return elementsN;
    }

    ConstrainedInteger insertionIndexK() {
        // TODO 自動生成されたメソッド・スタブ
        return insertionIndexK;
    }

    ConstrainedInteger insertionValueQ() {
        // TODO 自動生成されたメソッド・スタブ
        return insertionValueQ;
    }

    List<ConstrainedInteger> sourceValues() {
        // TODO 自動生成されたメソッド・スタブ
        return sourceValues;
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
