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

    void printRealNumber(final RealNumber rn) {
        // TODO 自動生成されたメソッド・スタブ
        DecimalFormat df = new DecimalFormat("0.###");
        out.println(df.format(rn.Number));
    }
}
