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

class Variable_array_bossTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String N_M = "10 4";
    private final String A = "1 2 3 4 5 6 7 8 9 10";
    private final String B = "2 6 1 1";

    @BeforeEach
    void before() {
        System.setIn(in);
        System.setOut(out);
        in.inputln(N_M);
        in.inputln(A);
        in.inputln(B);
    }

    @AfterEach
    void after() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("全体テスト")
    void testAll() {
        Variable_array_boss.main(null);
        String[] Answer = { "1 2", "3 4 5 6 7 8", "9", "10" };
        for (String ans : Answer) {
            assertEquals(ans, out.readLine());
        }
    }

    @Test
    @DisplayName("標準入力から 配列A[] とB[] を受け取る。 B[] の値分、A[] の要素を標準出力する")
    void testOutputUseCase() {
        try (Scanner sc = new Scanner(System.in)) {
            InputReader reader = new InputReader(sc);
            String[] NandM = reader.readTokensLine();
            String[] A = reader.readTokensLine();
            String[] B = reader.readTokensLine();
            String[] Answer = { "1 2", "3 4 5 6 7 8", "9", "10" };

            OutputWriter writer = new OutputWriter(System.out);
            OutputUseCase useCase = new OutputUseCase(writer);
            useCase.execute(A, B);
            for (String ans : Answer) {
                assertEquals(ans, out.readLine());
            }
        }
    }
}
