package stdout_primer.format_real_number;

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

class Step2Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String[] N = { "0.813", "10000000000.5" };

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
        in.inputln("0.813");
        Step2.main(null);
        assertEquals("0.813", out.readLine());
    }

    @Test
    void testAll_2() {
        in.inputln("10000000000.5");
        Step2.main(null);
        assertEquals("10000000000.5", out.readLine());
    }

    @Test
    @DisplayName("標準入力から 文字列 N を受け取る。N を実数に変換し、標準出力する")
    void testprintByRealNumber() {
        for (String n : N) {
            in.inputln(n);
        }

        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final String[] Answer = { "0.813", "10000000000.5" };

            for (String ans : Answer) {
                final double N = sc.nextDouble();
                final RealNumber_For_Step2 RealNumber = new RealNumber_For_Step2(N);
                writer.print_RealNumber(RealNumber);
                assertEquals(ans, out.readLine());
            }
        }
    }

}
