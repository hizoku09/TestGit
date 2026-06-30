package exam.c155;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final CheckAdvertisementPrinter printer = new CheckAdvertisementPrinter(System.out);
            final String s = sc.next();
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            sc.nextLine();
            final String t[] = new String[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                t[i] = sc.nextLine();
            }

            printer.printCheckAdvertisement(s, t);
        }
    }

}

final class CheckAdvertisementPrinter {
    private final PrintStream out;

    CheckAdvertisementPrinter(final PrintStream out) {
        this.out = out;
    }

    void printCheckAdvertisement(final String targetWord, final String[] checkLines) {
        for (final String line : checkLines) {
            if (line.contains(targetWord))
                out.println("Yes");
            else {
                out.println("No");
            }
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
    
    public ConstrainedInteger add(final int other) {
        final int added = this.value + other;
        return new ConstrainedInteger(added, constraint);
    }

    public ConstrainedInteger subtract(final int other) {
        // TODO 自動生成されたメソッド・スタブ
        final int subtracted = this.value - other;
        return new ConstrainedInteger(subtracted, constraint);
    }
    
    public ConstrainedInteger divide(final int other) {
        final int divided = this.value / other;
        return new ConstrainedInteger(divided, constraint);
    }
}

final class IntRange {
    final int minInclusive;
    final int maxInclusive;

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
