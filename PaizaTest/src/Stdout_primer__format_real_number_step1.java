import java.text.DecimalFormat;
import java.util.Scanner;

class Stdout_primer__format_real_number_step1 {

    private static final double MIN = 0.001;
    private static final double MAX = 99.999;

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            final String[] N = readTokensLine(sc);
            final double rn = RealNumber(N[0]);
            printRealNumber(rn);
        }
    }

    static String[] readTokensLine(final Scanner sc) {
        final String line = sc.nextLine().trim();
        if (line.isEmpty())
            return new String[0];
        final String[] result = line.split("\\s+");
        return result;
    }

    

    static double RealNumber(final String str) {
        if (str == null) {
            throw new NullPointerException("文字列を指定してください。");
        }

        final double result = Double.parseDouble(str);
        if (result < MIN | result >= MAX) {
            throw new IllegalArgumentException("数値は 0.001 以上もしくは 99.999 未満で入力してください。");
        }

        return result;
    }
    
    static void printRealNumber(final double rn) {
        DecimalFormat df = new DecimalFormat("0.###");
        System.out.println(df.format(rn));
    }

}
