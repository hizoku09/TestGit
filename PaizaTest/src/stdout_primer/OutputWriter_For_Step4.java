package stdout_primer;

import java.io.PrintStream;

class OutputWriter_For_Step4 {
    private final PrintStream out;

    OutputWriter_For_Step4(final PrintStream out) {
        this.out = out;
    }
    
    void print_DecimalplacesChecked_RealNumber(final RealNumber_0_001to99_999999 RealNumber, final Integer_1to4 Integer) {
        final int decimalplaces = Integer.value;
        out.printf("%." + decimalplaces + "f\n", RealNumber.value);
    }
}
