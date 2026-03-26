package stdout_primer;
import java.util.Scanner;

class Format_real_number_step1 {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final double N = sc.nextDouble();
            final RealNumber_For_Step1 RealNumber = new RealNumber_For_Step1(N);
            writer.printRealNumber(RealNumber);
        }
    }
}

/*
 * class RealNumber { 
 * final double value;
 * 
 * RealNumber(final double dbl) {
 * 
 * if (dbl < MIN | dbl >= MAX) { throw new
 * IllegalArgumentException("数値は 0.001 以上もしくは 99.999 未満で入力してください。"); }
 * 
 * this.value = dbl; } }
 * 
 * class InputReader { private final Scanner sc;
 * 
 * InputReader(final Scanner sc) { this.sc = sc; }
 * 
 * String[] readTokensLine() { final String line = sc.nextLine().trim(); if
 * (line.isEmpty()) return new String[0]; final String[] result =
 * line.split("\\s+"); return result; }
 * 
 * double readDouble() { final double result = sc.nextDouble(); return result; }
 * }
 * 
 * 
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
 * out.println(df.format(rn.value)); } }
 */