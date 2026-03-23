package stdout_primer;

import java.io.PrintStream;
import java.text.DecimalFormat;

class OutputWriter_ForStep3 {
    private final PrintStream out;

    OutputWriter_ForStep3(final PrintStream out) {
        this.out = out;
    }

    void printRealNumber(final RealNumber_For_Step3 RealNumber) {
        // TODO 自動生成されたメソッド・スタブ
        DecimalFormat df = new DecimalFormat("0.000");
        out.println(df.format(RealNumber.value));
    }
}
