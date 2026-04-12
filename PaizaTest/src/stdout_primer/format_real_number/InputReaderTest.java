package stdout_primer.format_real_number;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {
    private final InputStream originalIn = System.in;
    private final StandardInputStream in = new StandardInputStream();
    private final String Line = "10 4";

    @BeforeEach
    void before() {
        System.setIn(in);
    }

    @AfterEach
    void after() {
        System.setIn(originalIn);
    }

    @Test
    void testreadTokensLine() {
        in.inputln(Line);
        
        try (Scanner sc = new Scanner(in)) {
            InputReader reader = new InputReader(sc);
            final String[] answer = { "10", "4" };
            final String[] test = reader.readTokensLine();
            assertArrayEquals(test, answer);
        }
    }
}
