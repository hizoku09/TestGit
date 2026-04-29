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

class Step1Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();

    private final String[] N = { "813", "12", "0" };
    private final String[] Answer = { "813", " 12", "  0" };

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
        for (int i = 0; i < N.length; i++) {
            in.inputln(N[i]);
            Step1.main(null);
            assertEquals(Answer[i], out.readLine());
        }
            
    }

    @Test
    @DisplayName("自然数 N が与えられます。N が 3 けたになるよう数値の前に半角スペースを埋めて出力してください。")
    void testPrintNaturalNumber() {
        for (String input : N) {
            in.inputln(input);
        }

        try (Scanner sc = new Scanner(System.in)) {
            for (String answer : Answer) {
                final PaddedNumberPrinter writer = new PaddedNumberPrinter(System.out);
                final int N = sc.nextInt();
                final IntRange oneToThousand = new IntRange(0, 1000);
                final ConstrainedInteger naturalNumber = new ConstrainedInteger(N, oneToThousand);

                writer.printNaturalNumber3Digits(naturalNumber);

                assertEquals(answer, out.readLine());
            }
        }
    }

}
