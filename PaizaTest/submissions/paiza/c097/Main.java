package exam.c097;

import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final IntRange oneTo1000 = new IntRange(1, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger y = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final PrizewinnerPrinter printer = new PrizewinnerPrinter(System.out, PrizeRules.forAandB(x, y));

            printer.printPrizewinner(n);
        }
    }

}

final class PrizewinnerPrinter {
    private final PrintStream out;
    private final List<PrizeRule> rules;
    private final String defaultLabel = "N";

    PrizewinnerPrinter(final PrintStream out, final List<PrizeRule> rules) {
        this.out = out;
        this.rules = List.copyOf(rules);
    }
    
    void printPrizewinner(final ConstrainedInteger applicant) {
        for (int i = 1; i <= applicant.getValue(); i++) 
            out.println(labelFor(i));
    }
    
    private String labelFor(final int n) {
        final StringBuilder joinedLabels = new StringBuilder();
        final String result;

        for (final PrizeRule rule : rules) {
            if (rule.matches(n)) {
                joinedLabels.append(rule.label());
            }
        }
        result = joinedLabels.length() == 0 ? defaultLabel : joinedLabels.toString();
        
        return result;
    }
    
}

interface PrizeRule {
    boolean matches(int n);
    String label();
}

final class PrizeRules implements PrizeRule {
    private final ConstrainedInteger divisor;
    private final String label;

    PrizeRules(final ConstrainedInteger divisor, final String label) {
        this.divisor = divisor;
        this.label = label;
    }
    
    static List<PrizeRule> forAandB(ConstrainedInteger a, ConstrainedInteger b) {
        return List.of(
            new PrizeRules(a, "A"),
            new PrizeRules(b, "B")
        );
    }

    @Override
    public boolean matches(final int n) {
        return (n % divisor.getValue()) == 0;
    }

    @Override
    public String label() {
        return label;
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
