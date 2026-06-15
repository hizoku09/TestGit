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

class BossTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input1 = "2 3 7 8";
    private final String input2 = "3 2 999999999 0";

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
    void testAll() {
        in.inputln(input2);
        
        Boss.main(null);
        
        assertEquals("(999999999,         0) | (999999999,         0)", out.readLine());
        assertEquals("===============================================", out.readLine());
        assertEquals("(999999999,         0) | (999999999,         0)", out.readLine());
        assertEquals("===============================================", out.readLine());
        assertEquals("(999999999,         0) | (999999999,         0)", out.readLine());
    }

    @Test
    @DisplayName("自然数 H, W, A, B が与えられます。縦に H 行、横に W 列で計 H * W 個の (A, B) の形式で"
            + "文字列を出力してください。（AとBを、カンマと半角スペースで区切ってください。）" + "ただし、横は | (半角スペース バーティカルライン 半角スペース) 区切りで、"
            + "縦は = で区切って出力してください。" + "また、縦の文字列間で = を出力する際は、その上の行と文字数がそろうように出力します。"
            + "また、A と B は 9 けたになるように半角スペースを数値の前(右詰め)に埋めて出力してください。")
    void testprintMultiplicationTables9Digits() {
        in.inputln(input1);

        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger h = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final ConstrainedInteger w = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final IntRange zeroTo999999999 = new IntRange(0, 999999999);
            final ConstrainedInteger a = new ConstrainedInteger(sc.nextInt(), zeroTo999999999);
            final ConstrainedInteger b = new ConstrainedInteger(sc.nextInt(), zeroTo999999999);

            final int lasttime = h.getValue() - 1;
            for (int i = 0; i < h.getValue(); i++) {
                printer.printPadded2DpositionNtimesDelimiter(w, a, b);
                if (i < lasttime)
                    printer.printEqualLinesForPadded2Dposition(w.getValue());
            }

            assertEquals("(        7,         8) | (        7,         8) | (        7,         8)", out.readLine());
            assertEquals("========================================================================", out.readLine());
            assertEquals("(        7,         8) | (        7,         8) | (        7,         8)", out.readLine());
        }
    }

}
