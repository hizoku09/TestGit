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

class Step3Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();

    private final String N = "12";
    private final String[] M = { "0", "8", "81", "813", "0", "0", "0", "0", "0", "0", "0", "0" };
    private final String[] Answer = { "  0", "  8", " 81", "813", "  0", "  0", "  0", "  0", "  0", "  0", "  0",
            "  0" };

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);
        in.inputln(N);
        for (String input : M) {
            in.inputln(input);
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
        Step3.main(null);

        for (String ans : Answer) {
            assertEquals(ans, out.readLine());
        }
    }

    @Test
    @DisplayName("自然数 N が与えられます。N 個の自然数が与えられるので、それぞれを数値 M_i について以下の処理を行ってください。"
            + "* M_i が 3 けたになるよう数値の前に半角スペースを埋めて出力してください。")
    void testPrintNaturalNumber() {
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final IntRange zeroTo9999 = new IntRange(0, 10000);
            final ConstrainedInteger N = new ConstrainedInteger(sc.nextInt(), zeroTo9999);
            int M[] = new int[N.getValue()];
            for (int i = 0; i < N.getValue(); i++) {
                M[i] = sc.nextInt();
            }

            final IntRange zeroTo999 = new IntRange(0, 1000);
            for (int i = 0; i < N.getValue(); i++) {
                final ConstrainedInteger m = new ConstrainedInteger(M[i], zeroTo999);
                writer.printNaturalNumber3Digits(m);

                assertEquals(Answer[i], out.readLine());
            }
        }
    }

}
