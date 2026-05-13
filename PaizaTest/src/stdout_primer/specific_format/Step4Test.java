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
    private final String input1 = "2 3 7 8";
    private final String input2 = "3 2 0 0";

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
        in.inputln(input1);
        
        Step4.main(null);
        assertEquals("(7, 8) | (7, 8) | (7, 8)", out.readLine());
        assertEquals("========================", out.readLine());
        assertEquals("(7, 8) | (7, 8) | (7, 8)", out.readLine());
    }
    
    @Test
    @DisplayName("全体テスト")
    void testAll_2() {
        in.inputln(input2);
        
        Step4.main(null);
        assertEquals("(0, 0) | (0, 0)", out.readLine());
        assertEquals("===============", out.readLine());
        assertEquals("(0, 0) | (0, 0)", out.readLine());
        assertEquals("===============", out.readLine());
        assertEquals("(0, 0) | (0, 0)", out.readLine());
    }

    @Test
    @DisplayName("自然数 H, W, A, B が与えられます。" + "縦に H 行、横に W 行で計 H * W 個の (A, B) という形式の文字列を出力してください。"
            + "ただし、横は | (半角スペース バーティカルライン 半角スペース) 区切りで、" + "縦は = で区切って出力してください。"
            + "また、縦の文字列間で = を出力する際は、その上の行と文字数が等しくなるように出力します。")
    void testprintMultiplicationTables() {
        in.inputln(input1);
        
        try (Scanner sc = new Scanner(System.in)) {
            final SpecificStringsPrinter printer = new SpecificStringsPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger h = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final ConstrainedInteger w = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final IntRange zeroTo9 = new IntRange(0, 9);
            final ConstrainedInteger a = new ConstrainedInteger(sc.nextInt(), zeroTo9);
            final ConstrainedInteger b = new ConstrainedInteger(sc.nextInt(), zeroTo9);

            final int lasttime = h.getValue() - 1;
            for (int i = 0; i < h.getValue(); i++) {
                printer.print2DpositionNtimesDelimiter(w, a, b);
                if (i != lasttime)
                    printer.printEqualLinesFor2Dposition(w.getValue());
            }

            assertEquals("(7, 8) | (7, 8) | (7, 8)", out.readLine());
            assertEquals("========================", out.readLine());
            assertEquals("(7, 8) | (7, 8) | (7, 8)", out.readLine());
        }
    }

}
