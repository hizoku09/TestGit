package stdout_primer.format_real_number;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Format_real_number_step1Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String[] N = { "0.813", "99" };

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);
        for (String n : N) {
            in.inputln(n);
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
        Format_real_number_step1.main(null);
        assertEquals("0.813", out.readLine());
    }
    
    void testAll_2() {
        Format_real_number_step1.main(null);
        assertEquals("99", out.readLine());

    }

    @Test
    @DisplayName("標準入力から 文字列 N を受け取る。N を標準出力する")
    void testprintByRealNumber() {
        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter writer = new OutputWriter(System.out);
            final String[] Answer = { "0.813", "99" };

            for (String ans : Answer) {
                final double N = sc.nextDouble();
                final RealNumber_For_Step1 RealNumber = new RealNumber_For_Step1(N);
                writer.printRealNumber(RealNumber);
                assertEquals(ans, out.readLine());
            }
        }
    }

}
