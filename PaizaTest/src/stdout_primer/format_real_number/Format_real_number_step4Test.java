package stdout_primer.format_real_number;

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
    private final String[] N_M = { "0.813 1", "0.813 2", "0.813 3", "0.813 4" };
    private final String[] Answer = { "0.8", "0.81", "0.813", "0.8130" };

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
        in.inputln("0.813 1");
        Format_real_number_step4.main(null);
        assertEquals("0.8", out.readLine());
    }

    @Test
    void testAll_2() {
        in.inputln("0.813 2");
        Format_real_number_step4.main(null);
        assertEquals("0.81", out.readLine());
    }

    @Test
    void testAll_3() {
        in.inputln("0.813 3");
        Format_real_number_step4.main(null);
        assertEquals("0.813", out.readLine());
    }
    
    @Test
    void testAll_4() {
        in.inputln("0.813 4");
        Format_real_number_step4.main(null);
        assertEquals("0.8130", out.readLine());
    }

    @Test
    @DisplayName("標準入力から 文字列 N と M を受け取り。N を実数、 M を整数に代入する" 
    + "小数点第 M 位まで丸めて N を出力する。小数点第 M 位未満の場合、足りない分を 0 で埋める")
    void testprintRealNumber_by_Decimalpoints() {

        for (String input : N_M) {
            in.inputln(input);
        }

        try (Scanner sc = new Scanner(System.in)) {
            final OutputWriter_For_Step4 writer = new OutputWriter_For_Step4(System.out);

            for (String ans : Answer) {
                final double N = sc.nextDouble();
                final int M = sc.nextInt();

                final RealNumber_greater0_001_under99_999999 RealNumber = new RealNumber_greater0_001_under99_999999(N);
                final NaturalNumber_1to4 Integer = new NaturalNumber_1to4(M);

                writer.print_DecimalplacesChecked_RealNumber(RealNumber, Integer);
                assertEquals(ans, out.readLine());
            }
        }
    }

}
