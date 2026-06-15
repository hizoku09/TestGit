package stdout_primer.format_real_number;

import java.io.PrintStream;

class OutputWriter_For_Step4 {
    private final PrintStream out;

    OutputWriter_For_Step4(final PrintStream out) {
        this.out = out;
    }
    
    void print_DecimalplacesChecked_RealNumber(final RealNumber_greater0_001_under99_999999 realNumber,
            final NaturalNumber_1to4 naturalNumber) {
        final int decimalplaces = naturalNumber.value;
        out.printf("%." + decimalplaces + "f\n", realNumber.value);
    }
}
