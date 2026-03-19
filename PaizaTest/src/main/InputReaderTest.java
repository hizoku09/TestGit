package main;

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
    private final String Double = "0.813";

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
    
    @Test
    void testreadDouble() {
        in.inputln(Double);
        
        try (Scanner sc = new Scanner(in)) {
            InputReader reader = new InputReader(sc);
            final double answer = 0.813;
            final double test = reader.readDouble();
            assertEquals(test, answer);
        }
    }
}
