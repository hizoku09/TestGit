package c_rank_skillcheck_sample;

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

class FizzBuzzTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input1 = "5";
    private final String input2 = "20";

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
    void testAll() {
        in.inputln(input2);
        
        FizzBuzz.main(null);
        
        assertEquals("1", out.readLine());
        assertEquals("2", out.readLine());
        assertEquals("Fizz", out.readLine());
        assertEquals("4", out.readLine());
        assertEquals("Buzz", out.readLine());
        assertEquals("Fizz", out.readLine());
        assertEquals("7", out.readLine());
        assertEquals("8", out.readLine());
        assertEquals("Fizz", out.readLine());
        assertEquals("Buzz", out.readLine());
        assertEquals("11", out.readLine());
        assertEquals("Fizz", out.readLine());
        assertEquals("13", out.readLine());
        assertEquals("14", out.readLine());
        assertEquals("Fizz Buzz", out.readLine());
        assertEquals("16", out.readLine());
        assertEquals("17", out.readLine());
        assertEquals("Fizz", out.readLine());
        assertEquals("19", out.readLine());
        assertEquals("Buzz", out.readLine());
    }

    @Test
    @DisplayName("整数 N が入力として与えられます。\n"
            + "1からNまでの整数を1から順に表示してください。\n"
            + "ただし、表示しようとしている数値が、\n"
            + "・3の倍数かつ5の倍数のときには、\"Fizz Buzz\"\n"
            + "・3の倍数のときには、\"Fizz\"\n"
            + "・5の倍数のときには、\"Buzz\"\n"
            + "を数値の代わりに表示してください。")
    void testprintFizzBuzz1() {
        in.inputln(input1);

        try (Scanner sc = new Scanner(System.in)) {
            final FizzBuzzPrinter printer = new FizzBuzzPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            
            for (int i = 1; i <= n.getValue(); i++)
                printer.printFizzBuzz(i);

            assertEquals("1", out.readLine());
            assertEquals("2", out.readLine());
            assertEquals("Fizz", out.readLine());
            assertEquals("4", out.readLine());
            assertEquals("Buzz", out.readLine());
        }
    }
    
    @Test
    @DisplayName("FizzBuzz出力")
    void testprintFizzBuzz2() {
        in.inputln(input2);

        try (Scanner sc = new Scanner(System.in)) {
            final FizzBuzzPrinter printer = new FizzBuzzPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            
            for (int i = 1; i <= n.getValue(); i++)
                printer.printFizzBuzz(i);

            assertEquals("1", out.readLine());
            assertEquals("2", out.readLine());
            assertEquals("Fizz", out.readLine());
            assertEquals("4", out.readLine());
            assertEquals("Buzz", out.readLine());
            assertEquals("Fizz", out.readLine());
            assertEquals("7", out.readLine());
            assertEquals("8", out.readLine());
            assertEquals("Fizz", out.readLine());
            assertEquals("Buzz", out.readLine());
            assertEquals("11", out.readLine());
            assertEquals("Fizz", out.readLine());
            assertEquals("13", out.readLine());
            assertEquals("14", out.readLine());
            assertEquals("Fizz Buzz", out.readLine());
            assertEquals("16", out.readLine());
            assertEquals("17", out.readLine());
            assertEquals("Fizz", out.readLine());
            assertEquals("19", out.readLine());
            assertEquals("Buzz", out.readLine());
        }
    }

}
