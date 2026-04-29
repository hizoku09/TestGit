package stdout_primer.print_width;

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

class Step4Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();

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
        final String N = "813";
        final String M = "4";
        in.inputln(N);
        in.inputln(M);
        
        Step4.main(null);

        assertEquals(" 813", out.readLine());
    }

    @Test
    @DisplayName("自然数 N, M が与えられます。N が M けたになるよう数値の前に半角スペースを埋めて出力してください。")
    void testPrintNaturalNumber() {
        final String N = "813";
        final String M = "4";
        in.inputln(N);
        in.inputln(M);

        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final IntRange zeroTo999 = new IntRange(0, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), zeroTo999);
            final IntRange oneTo10 = new IntRange(1, 11);
            final ConstrainedInteger m = new ConstrainedInteger(sc.nextInt(), oneTo10);

            writer.printNaturalNumberDigitsOf(n, m);

            assertEquals(" 813", out.readLine());
        }
    }

    @Test
    @DisplayName("自然数 N, M が与えられます。N が M けたになるよう数値の前に半角スペースを埋めて出力してください。")
    void testPrintNaturalNumber2() {
        final String N = "813";
        final String M = "8";
        in.inputln(N);
        in.inputln(M);

        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final IntRange zeroTo999 = new IntRange(0, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), zeroTo999);
            final IntRange oneTo10 = new IntRange(1, 11);
            final ConstrainedInteger m = new ConstrainedInteger(sc.nextInt(), oneTo10);

            writer.printNaturalNumberDigitsOf(n, m);

            assertEquals("     813", out.readLine());
        }
    }

}
