package stdout_primer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Format_real_number_step4Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String[] N_M = { "0.813 1", "0.813 2" };

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
        Format_real_number_step3.main(null);
        assertEquals("0.813", out.readLine());
    }

    @Test
    void testAll_2() {
        in.inputln("8.13");
        Format_real_number_step3.main(null);
        assertEquals("8.130", out.readLine());
    }

    @Test
    void testAll_3() {
        in.inputln("3.141692");
        Format_real_number_step3.main(null);
        assertEquals("3.142", out.readLine());
    }

    @Test
    @DisplayName("標準入力から 文字列 N を受け取る。N を実数に変換し、標準出力する"
            + "小数点第三位まで出力する。N の小数部が小数第三位に満たない場合は 0 で埋める")
    void testprintByRealNumber() {
        for (String n : N) {
            in.inputln(n);
        }

        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter_ForStep3 writer = new OutputWriter_ForStep3(System.out);
            final String[] Answer = { "0.813", "8.130", "3.142" };

            for (String ans : Answer) {
                final double N = sc.nextDouble();
                final RealNumber_0_001to99_999999 RealNumber = new RealNumber_0_001to99_999999(N);

                writer.print_DecimalplacesChecked_RealNumber(RealNumber);
                assertEquals(ans, out.readLine());
            }
        }
    }

}
