package exam.c097;

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

class C097Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input1 = "5 2 4";
    private final String input2 = "6 3 2";

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
        in.inputln(input1);

        C097.main(null);

        assertEquals("N", out.readLine());
        assertEquals("A", out.readLine());
        assertEquals("N", out.readLine());
        assertEquals("AB", out.readLine());
        assertEquals("N", out.readLine());
    }

    @Test
    @DisplayName("入力は以下のフォーマットで与えられます。\n"
            + "N X Y\n"
            + "・1 行目にはそれぞれ整数 N, X, Y がこの順で半角スペース区切りで与えられます。これらは応募者が N 人であることを示し、X の倍数番目の応募者がプレゼント A の当選者となり、Y の倍数番目の応募者がプレゼント B の当選者となることを示します。\n"
            + "・入力は 1 行となり、末尾に改行が 1 つ入ります。"
            + "それぞれの応募者の当選情報を以下の形式で出力してください。\n"
            + "a_1\n"
            + "a_2\n"
            + "...\n"
            + "a_N\n"
            + "・期待する出力は N 行からなります。\n"
            + "・i 行目 (1 ≦ i ≦ N) にはそれぞれ i 番目の応募者の当選情報を出力してください。\n"
            + "・プレゼント A に当選しているとき、大文字アルファベットの A を、プレゼント B に当選しているとき、大文字アルファベットの B を、プレゼント A、Bの両方当選しているとき、大文字アルファベットの AB を出力し、当選していないとき、大文字アルファベットの N を出力してください。\n"
            + "・出力最終行の末尾に改行を入れ、余計な文字、空行を含んではいけません。"
            + "すべてのテストケースにおいて、以下の条件をみたします。\n"
            + "・1 ≦ N ≦ 1,000\n"
            + "・1 ≦ X, Y ≦ N")
    void testprintPrizewinner1() {
        in.inputln(input1);

        try (Scanner sc = new Scanner(System.in)) {
            final IntRange oneTo1000 = new IntRange(1, 1000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger y = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final PrizewinnerPrinter printer = new PrizewinnerPrinter(System.out, 
                    PrizeRules.forAandB(x, y));

            printer.printPrizewinner(n);

            assertEquals("N", out.readLine());
            assertEquals("A", out.readLine());
            assertEquals("N", out.readLine());
            assertEquals("AB", out.readLine());
            assertEquals("N", out.readLine());
        }
    }

    @Test
    void testprintPrizewinner2() {
        in.inputln(input2);

        try (Scanner sc = new Scanner(System.in)) {
            final IntRange oneTo1000 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final ConstrainedInteger y = new ConstrainedInteger(sc.nextInt(), oneTo1000);
            final PrizewinnerPrinter printer = new PrizewinnerPrinter(System.out, 
                    PrizeRules.forAandB(x, y));

            printer.printPrizewinner(n);

            assertEquals("N", out.readLine());
            assertEquals("B", out.readLine());
            assertEquals("A", out.readLine());
            assertEquals("B", out.readLine());
            assertEquals("N", out.readLine());
            assertEquals("AB", out.readLine());
        }
    }

}
