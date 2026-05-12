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

class Step4Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input = "2 3 7 8";

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);
        in.inputln(input);
    }

    @AfterEach
    void after() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

//    @Test
//    @DisplayName("全体テスト")
//    void testAll_1() {
//        Step4.main(null);
//        assertEquals(" 1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 2 |  4 |  6 |  8 | 10 | 12 | 14 | 16 | 18", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 3 |  6 |  9 | 12 | 15 | 18 | 21 | 24 | 27", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 4 |  8 | 12 | 16 | 20 | 24 | 28 | 32 | 36", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 5 | 10 | 15 | 20 | 25 | 30 | 35 | 40 | 45", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 6 | 12 | 18 | 24 | 30 | 36 | 42 | 48 | 54", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 7 | 14 | 21 | 28 | 35 | 42 | 49 | 56 | 63", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 8 | 16 | 24 | 32 | 40 | 48 | 56 | 64 | 72", out.readLine());
//        assertEquals("==========================================", out.readLine());
//        assertEquals(" 9 | 18 | 27 | 36 | 45 | 54 | 63 | 72 | 81", out.readLine());
//    }

    @Test
    @DisplayName("自然数 H, W, A, B が与えられます。" + "縦に H 行、横に W 行で計 H * W 個の (A, B) という形式の文字列を出力してください。"
            + "ただし、横は | (半角スペース バーティカルライン 半角スペース) 区切りで、" + "縦は = で区切って出力してください。"
            + "また、縦の文字列間で = を出力する際は、その上の行と文字数が等しくなるように出力します。")
    void testprintMultiplicationTables() {
        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final ConstrainedInteger w = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final IntRange zeroTo9 = new IntRange(0, 9);
            final ConstrainedInteger a = new ConstrainedInteger(sc.nextInt(), zeroTo9);
            final ConstrainedInteger b = new ConstrainedInteger(sc.nextInt(), zeroTo9);

            printer.print2DpositionNtimesDelimiter(w, a, b);
            printer.printEqualLinesStep4(w.getValue());

            assertEquals("(7, 8) | (7, 8) | (7, 8)", out.readLine());
            assertEquals("========================", out.readLine());
//            assertEquals("(7, 8) | (7, 8) | (7, 8)", out.readLine());
        }
    }

}
