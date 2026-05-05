package stdout_primer.specific_format;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;
import valueobjects.StandardInputStream;
import valueobjects.StandardOutputStream;

class Step2Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String N = "3 10 99";

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);
    }

    @AfterEach
    void after() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

//    @Test
//    @DisplayName("全体テスト")
//    void testAll_1() {
//        in.inputln(S1);
//        in.inputln(T1);
//        Step1.main(null);
//        assertEquals("kirishima + kyoko = kirishimakyoko", out.readLine());
//    }
//
//    @Test
//    @DisplayName("全体テスト")
//    void testAll_2() {
//        in.inputln(S2);
//        in.inputln(T2);
//        Step1.main(null);
//        assertEquals("S + T = ST", out.readLine());
//    }

    @Test
    @DisplayName("自然数 N, A, B が与えられます。(A, B) という形式の文字列を N 回、カンマと半角スペース区切りで出力してください。")
    void testStrings2Dposition() {
        in.inputln(N);
        in.inputln(N);
        in.inputln(N);

        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 101);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            
            for (int i = 0; i < n.getValue(); i++) {
                final ConstrainedInteger a = new ConstrainedInteger(sc.nextInt(), oneTo100);
                final ConstrainedInteger b = new ConstrainedInteger(sc.nextInt(), oneTo100);
                printer.printStrings2Dposition(a, b);
            }

            assertEquals("(10, 99), (10, 99), (10, 99)", out.readLine());
        }
    }

}
