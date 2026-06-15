package stdout_primer.format_real_number;
//import java.io.PrintStream;
import java.util.Scanner;

class Step3 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final double N = sc.nextDouble();
            final RealNumber_greater0_001_under99_999999 RealNumber = new RealNumber_greater0_001_under99_999999(N);
            writer.print_DecimalplacesChecked_RealNumber(RealNumber);
        }
    }
}

/*
 * class OutputWriter_ForStep3 { private final PrintStream out;
 * 
 * OutputWriter_ForStep3(final PrintStream out) { this.out = out; }
 * 
 * void print_DecimalplacesChecked_RealNumber(final RealNumber_For_Step3
 * RealNumber) { out.printf("%.3f\n", RealNumber.value); } }
 * 
 * class RealNumber_For_Step3 {
 * 
 * private static final double MAX = 99.999999; private static final double MIN
 * = 0.001; final double value;
 * 
 * RealNumber_For_Step3(final double value) { illegalcheck(value); this.value =
 * value; }
 * 
 * void illegalcheck(final double value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * }
 */