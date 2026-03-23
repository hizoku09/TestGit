package stdout_primer;

/*import java.io.PrintStream;
import java.text.DecimalFormat;*/
import java.util.Scanner;

class Format_real_number_step2 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final double N = sc.nextDouble();
            final IllegalCheck_format_real_number_step2 IllegalChecked_rn = new IllegalCheck_format_real_number_step2(
                    N);
            writer.printRealNumber(IllegalChecked_rn);
        }
    }
}

/*
 * class OutputWriter { private final PrintStream out;
 * 
 * OutputWriter(final PrintStream out) { this.out = out; }
 * 
 * void printlnTokens(final String[] tokens) { for (int i = 0; i <
 * tokens.length; i++) { if (i > 0) out.print(" "); out.print(tokens[i]); }
 * out.println(); }
 * 
 * void printRealNumber(final RealNumber rn) { // TODO 自動生成されたメソッド・スタブ
 * DecimalFormat df = new DecimalFormat("0.###");
 * out.println(df.format(rn.getValue())); } }
 * 
 * interface RealNumber { void IllegalCheck(final double value);
 * 
 * double getValue(); }
 * 
 * class IllegalCheck_format_real_number_step2 implements RealNumber { private
 * static final double MAX = 999999999999.999; private static final double MIN =
 * 0.001; private final double value;
 * 
 * IllegalCheck_format_real_number_step2(final double value) {
 * IllegalCheck(value); this.value = value; }
 * 
 * public void IllegalCheck(final double value) { if (value < MIN | value >=
 * MAX) { throw new
 * IllegalArgumentException("数値は 0.001 以上もしくは 999999999999.999 未満で入力してください。"); }
 * }
 * 
 * public double getValue() { return value; } }
 */