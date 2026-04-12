package stdout_primer.format_real_number;

//import java.io.PrintStream;
import java.util.Scanner;

class Format_real_number_step4 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter_For_Step4 writer = new OutputWriter_For_Step4(System.out);

            final double N = sc.nextDouble();
            final int M = sc.nextInt();

            final RealNumber_greater0_001_under99_999999 RealNumber = new RealNumber_greater0_001_under99_999999(N);
            final NaturalNumber_1to4 Integer = new NaturalNumber_1to4(M);

            writer.print_DecimalplacesChecked_RealNumber(RealNumber, Integer);
        }
    }
}

/*
 * class OutputWriter_For_Step4 { private final PrintStream out;
 * 
 * OutputWriter_For_Step4(final PrintStream out) { this.out = out; }
 * 
 * void print_DecimalplacesChecked_RealNumber(final RealNumber_0_001to99_999999
 * RealNumber, final Integer_1to4 Integer) { final int decimalplaces =
 * Integer.value; out.printf("%." + decimalplaces + "f\n", RealNumber.value); }
 * }
 * 
 * class RealNumber_0_001to99_999999 {
 * 
 * private static final double MAX = 99.999999; private static final double MIN
 * = 0.001; final double value;
 * 
 * RealNumber_0_001to99_999999(final double value) { illegalcheck(value);
 * this.value = value; }
 * 
 * void illegalcheck(final double value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * }
 * 
 * class Integer_1to4 {
 * 
 * private static final int MAX = 5; private static final int MIN = 1; final int
 * value;
 * 
 * Integer_1to4(final int value) { illegalcheck(value); this.value = value; }
 * 
 * void illegalcheck(final int value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * }
 */