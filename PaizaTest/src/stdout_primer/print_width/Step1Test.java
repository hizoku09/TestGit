package stdout_primer.print_width;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import valueobjects.Constrained_integer_object;
import valueobjects.IntConstraint;
import valueobjects.IntRange;

class Step1Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();

    private final String[] N = { "12", "0" };
    private final String[] Answer = { " 12", "  0" };

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);

        for (String input : N) {
            in.inputln(input);
        }
    }

    @AfterEach
    void after() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
    /*
     * @Test
     * 
     * @DisplayName("全体テスト") void testAll_1() { Step1.main(null);
     * 
     * for (String ans : Answer) { assertEquals(ans, out.readLine()); } }
     */

    @Test
    @DisplayName("自然数 N が与えられます。N が 3 けたになるよう数値の前に半角スペースを埋めて出力してください。")
    void testPrintNaturalNumber() {

        for (String answer : Answer) {
            try (Scanner sc = new Scanner(System.in)) {
                final OutputWriter writer = new OutputWriter(System.out);
                final int N = sc.nextInt();
                final IntConstraint oneTo999 = new IntRange(0, 999);
                final Constrained_integer_object naturalNumber = new Constrained_integer_object(N, oneTo999);

                writer.printNaturalNumber3Digits(naturalNumber);

                assertEquals(answer, out.readLine());
            }
        }
    }

}
