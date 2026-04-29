package stdout_primer.specific_format;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import valueobjects.StandardInputStream;
import valueobjects.StandardOutputStream;

class Step1Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String S1 = "kirishima";
    private final String T1 = "kyoko";
    private final String S2 = "S";
    private final String T2 = "T";

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

    @Test
    @DisplayName("全体テスト")
    void testAll_1() {
        in.inputln(S1);
        in.inputln(T1);
        Step1.main(null);
        assertEquals("kirishima + kyoko = kirishimakyoko", out.readLine());
    }

    @Test
    @DisplayName("全体テスト")
    void testAll_2() {
        in.inputln(S2);
        in.inputln(T2);
        Step1.main(null);
        assertEquals("S + T = ST", out.readLine());
    }

    @Test
    @DisplayName("文字列 S, T が与えられます。S + T = ST という形式で文字列を出力してください。")
    void testPrintConnectedStrings() {
        in.inputln(S1);
        in.inputln(T1);

        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final String s = sc.next();
            final String t = sc.next();

            writer.printConnectedStrings(s, t);

            assertEquals("kirishima + kyoko = kirishimakyoko", out.readLine());
        }
    }

}
