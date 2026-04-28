package stdout_primer.specific_format;

import java.util.Scanner;

class Step1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final String S = sc.next();
            final String T = sc.next();

            writer.printConnectedStrings(S, T);
        }
    }

}

//class OutputWriter {
//    private final PrintStream out;
//
//    OutputWriter(final PrintStream out) {
//        this.out = out;
//    }
//
//    void printConnectedStrings(final String s, final String t) {
//        out.print(s + " + " + t + " = " + s + t);
//    }
//    
//}
