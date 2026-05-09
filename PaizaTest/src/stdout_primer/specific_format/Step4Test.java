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
    @DisplayName("九九表を、横の数値間では | (半角スペース バーティカルライン 半角スペース)、縦の数値間では = で区切って出力してください。\n"
            + "ただし、数値を出力する際は 2 けたになるよう半角スペース埋めで出力します。また、縦の数値間で = を出力する際は、その上の行と文字数が等しくなるように出力します。")
    void testprintMultiplicationTables() {
        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);

            printer.printMultiplicationTables();

            assertEquals(" 1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 2 |  4 |  6 |  8 | 10 | 12 | 14 | 16 | 18", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 3 |  6 |  9 | 12 | 15 | 18 | 21 | 24 | 27", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 4 |  8 | 12 | 16 | 20 | 24 | 28 | 32 | 36", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 5 | 10 | 15 | 20 | 25 | 30 | 35 | 40 | 45", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 6 | 12 | 18 | 24 | 30 | 36 | 42 | 48 | 54", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 7 | 14 | 21 | 28 | 35 | 42 | 49 | 56 | 63", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 8 | 16 | 24 | 32 | 40 | 48 | 56 | 64 | 72", out.readLine());
            assertEquals("==========================================", out.readLine());
            assertEquals(" 9 | 18 | 27 | 36 | 45 | 54 | 63 | 72 | 81", out.readLine());
        }
    }


}
