package stdout_primer;

//import java.io.PrintStream;
import java.util.Scanner;

class Format_real_number_boss {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter_For_Step4 writer = new OutputWriter_For_Step4(System.out);

            final int Q = sc.nextInt();
            final NaturalNumber_1to100 Q_NaturalNumber = new NaturalNumber_1to100(Q);

            for (int i = 0; i < Q_NaturalNumber.value; i++) {
                final double N = sc.nextDouble();
                final int M = sc.nextInt();

                final RealNumber_greater0_001_under99_999999 RealNumber = new RealNumber_greater0_001_under99_999999(N);
                final NaturalNumber_1to4 NaturalNumber = new NaturalNumber_1to4(M);

                writer.print_DecimalplacesChecked_RealNumber(RealNumber, NaturalNumber);
            }
        }
    }

}

/*
 * class OutputWriter_For_Step4 { private final PrintStream out;
 * 
 * OutputWriter_For_Step4(final PrintStream out) { this.out = out; }
 * 
 * void print_DecimalplacesChecked_RealNumber(final
 * RealNumber_greater0_001_under99_999999 realNumber, final NaturalNumber_1to4
 * naturalNumber) { final int decimalplaces = naturalNumber.value;
 * out.printf("%." + decimalplaces + "f\n", realNumber.value); } }
 * 
 * class RealNumber_greater0_001_under99_999999 {
 * 
 * private static final double MAX = 99.999999; private static final double MIN
 * = 0.001; final double value;
 * 
 * RealNumber_greater0_001_under99_999999(final double value) {
 * illegalcheck(value); this.value = value; }
 * 
 * void illegalcheck(final double value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * }
 * 
 * class NaturalNumber_1to4 {
 * 
 * private static final int MAX = 5; private static final int MIN = 1; final int
 * value;
 * 
 * NaturalNumber_1to4(final int value) { illegalcheck(value); this.value =
 * value; }
 * 
 * void illegalcheck(final int value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * }
 * 
 * class NaturalNumber_1to100 {
 * 
 * private static final int MAX = 101; private static final int MIN = 1; final
 * int value;
 * 
 * NaturalNumber_1to100(final int value) { illegalcheck(value); this.value =
 * value; }
 * 
 * void illegalcheck(final int value) { if (value < MIN) { throw new
 * IllegalArgumentException("数値は " + MIN + " 以上で入力してください。"); } if (value >= MAX)
 * { throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。"); } }
 * 
 * }
 */