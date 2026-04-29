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

class BossTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    final String N = "4";
    final String M = "3";
    final String[] Ai = { "0", "8", "81", "813" };
    final String[] Answer = { "  0", "  8", " 81", "813" };

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);
        in.inputln(N);
        in.inputln(M);
        for (String ai : Ai) {
            in.inputln(ai);
        }
    }

    @AfterEach
    void after() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("全体テスト")
    void testAll_1() {
        Boss.main(null);

        for (String ans : Answer) {
            assertEquals(ans, out.readLine());
        }
    }

    @Test
    @DisplayName("整数 N, M と N 個の整数 A_1, A_2, ..., A_N が与えられます。"
            + "それぞれの数値が M けたになるよう数値の前に半角スペースを埋めて、改行区切りで出力してください。")
    void testPrintNaturalNumber() {
        try (Scanner sc = new Scanner(System.in)) {
            final PaddedNumberPrinter writer = new PaddedNumberPrinter(System.out);
            
            final IntRange oneTo99 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo99);
            final IntRange oneTo10 = new IntRange(1, 11);
            final ConstrainedInteger m = new ConstrainedInteger(sc.nextInt(), oneTo10);
            final IntRange zeroTo999 = new IntRange(0, 1000);
            final int length = n.getValue();
            final ConstrainedInteger ai[] = new ConstrainedInteger[length];
            for (int i = 0; i < length; i++) {
                ai[i] = new ConstrainedInteger(sc.nextInt(), zeroTo999);
                
            }

            writer.printArrayPaddedHalfWidthSpace(ai, m);

            for (String ans : Answer) {
                assertEquals(ans, out.readLine());
            }
        }
    }

}
