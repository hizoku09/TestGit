package stdout_primer;

import java.io.PrintStream;

class OutputWriter_ForStep3 {
    private final PrintStream out;

    OutputWriter_ForStep3(final PrintStream out) {
        this.out = out;
    }

    void print_DecimalplacesChecked_RealNumber(final RealNumber_0_001to99_999999 RealNumber) {
        out.printf("%.3f\n", RealNumber.value);
    }
}
