package stdout_primer;

/*import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;*/
import java.util.Scanner;

class Format_real_number_step3 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter_ForStep3 writer = new OutputWriter_ForStep3(System.out);
            final double N = sc.nextDouble();
            final RealNumber_For_Step3 RealNumber = new RealNumber_For_Step3(N);
            writer.printRealNumber(RealNumber);
        }
    }
}
/*
 * class OutputWriter_ForStep3 { private final PrintStream out;
 * 
 * OutputWriter_ForStep3(final PrintStream out) { this.out = out; }
 * 
 * void printRealNumber(final RealNumber_For_Step3 RealNumber) { // TODO
 * 自動生成されたメソッド・スタブ DecimalFormat df = new DecimalFormat("0.000");
 * out.println(df.format(RealNumber.value)); } }
 * 
 * class RealNumber_For_Step3 {
 * 
 * private static final double MAX = 99.999999; private static final double MIN
 * = 0.001; final double value;
 * 
 * RealNumber_For_Step3(final double value) { illegalcheck(value); final double
 * decimalplacesChecked_RealNumber = decimalplacesCheck(value); this.value =
 * decimalplacesChecked_RealNumber; }
 * 
 * public void illegalcheck(final double value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * double decimalplacesCheck(final double value) { BigDecimal result =
 * BigDecimal.valueOf(value);
 * 
 * if (result.scale() >= 4) result = result.setScale(3, RoundingMode.HALF_UP);
 * 
 * return result.doubleValue(); }
 * 
 * }
 */