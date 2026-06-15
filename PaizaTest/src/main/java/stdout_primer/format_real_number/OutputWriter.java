package stdout_primer.format_real_number;

import java.io.PrintStream;
import java.text.DecimalFormat;

class OutputWriter {
    private final PrintStream out;

    OutputWriter(final PrintStream out) {
        this.out = out;
    }

    void printlnTokens(final String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0)
                out.print(" ");
            out.print(tokens[i]);
        }
        out.println();
    }

    void printRealNumber(final RealNumber_For_Step1 RealNumber) {
        // TODO 自動生成されたメソッド・スタブ
        DecimalFormat df = new DecimalFormat("0.###");
        out.println(df.format(RealNumber.value));
    }
    
    void print_RealNumber(final RealNumber_For_Step2 RealNumber) {
        DecimalFormat df = new DecimalFormat("0.###");
        out.println(df.format(RealNumber.value));
    }
    
    void print_DecimalplacesChecked_RealNumber(final RealNumber_greater0_001_under99_999999 RealNumber) {
        out.printf("%.3f\n", RealNumber.value);
    }
}
