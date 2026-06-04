package c_rank_exam.C097;

import java.io.PrintStream;
import java.util.List;

import valueobjects.ConstrainedInteger;

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
