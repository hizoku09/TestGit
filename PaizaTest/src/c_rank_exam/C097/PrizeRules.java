package c_rank_exam.C097;

import java.util.List;

import valueobjects.ConstrainedInteger;

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
