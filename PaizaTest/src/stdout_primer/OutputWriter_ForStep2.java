package stdout_primer;

import java.io.PrintStream;
import java.text.DecimalFormat;

class OutputWriter_ForStep2 {
    private final PrintStream out;

    OutputWriter_ForStep2(final PrintStream out) {
        this.out = out;
    }

    void print_RealNumber(final RealNumber_For_Step2 RealNumber) { // TODO 自動生成されたメソッド・スタブ
        DecimalFormat df = new DecimalFormat("0.###");
        out.println(df.format(RealNumber.value));
    }
}
