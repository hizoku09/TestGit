package stdout_primer.specific_format;

import java.util.Scanner;

class Step1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsOutput writer = new SpecificStringsOutput(System.out);
            final String S = sc.next();
            final String T = sc.next();

            writer.printConnectedStrings(S, T);
        }
    }

}

//class SpecificStringsOutput {
//    private final PrintStream out;
//
//    SpecificStringsOutput(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printConnectedStrings(final String s, final String t) {
//        out.printf("%s + %s = %s\n", s, t, s + t);
//    }
//    
//}
