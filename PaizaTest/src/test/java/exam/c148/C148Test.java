package exam.c148;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;
import valueobjects.StandardInputStream;
import valueobjects.StandardOutputStream;

class C148Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input1 = "5 10\n" + "5\n" + "11\n" + "20\n" + "8\n" + "7";
    private final String input2 = "3 9\n" + "10\n" + "4\n" + "4";

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

    static Stream<TestCase> cases() {
        return Stream.of(new TestCase("c148/case1.in", "c148/case1.out"));
    }

    @Test
    @DisplayName("全体テスト")
    void testAll() {
        in.inputln(input1);

        C148.main(null);

        assertEquals("11", out.readLine());
    }

    @ParameterizedTest
    @MethodSource("cases")
    void testAll2(final TestCase tc) {
        in.inputText(TestResources.readResourceText(tc.inputResource));
        C148.main(null);

        final String expected = TestResources.readResourceText(tc.expectedResource);
        for (final String line : expected.split("\\R")) {
            assertEquals(line, out.readLine());
        }
    }

    static final class TestCase {
        final String inputResource;
        final String expectedResource;

        TestCase(final String inputResource, final String expectedResource) {
            this.inputResource = inputResource;
            this.expectedResource = expectedResource;
        }

        @Override
        public String toString() {
            return inputResource;
        }
    }

//    "あなたは異世界に転生した勇者です。この世界にはレベルという概念があり、戦闘を起こした際、レベルが高い方が勝利となります。"
//    + "勝利した側は相手のレベルの半分 (小数点以下切り捨て) だけレベルが上昇し、敗北した側はレベルが半分 (小数点以下切り捨て) になります。"
//    + "またレベルが同じ場合戦闘は引き分けとなり、レベルの変動は起きません。\n"
//    + "例えばあなたのレベルが 20 で、戦闘相手のレベルが 11 のとき、あなたの勝利となります。"
//    + "戦闘後、あなたのレベルは 5 上昇し 25 に、相手のレベルは 5 になります。\n"
//    + "あなたはこの世界でのレベルの変化をシミュレーションしようと考えています。\n"
//    + "戦闘を始める前のあなたのレベルと、N 回の戦闘で戦う相手のレベルが順に与えられるので、N 回の戦闘後にあなたのレベルがいくつになったかを出力してください。"
//    + "・1 行目に戦闘回数の N と、最初のあなたのレベル L が与えられます。\n"
//    + "・続く N 行の各行には i 番目 (1 ≦ i ≦ N) の戦闘相手のレベルが x_i であるという情報が与えられます。\n"
//    + "・入力は合計で N+1 行からなり、入力値最終行の末尾に改行が 1 つ入ります。"
    @Test
    void testprintPlayerLevelAfterBattle1() {
        in.inputln(input1);

        try (Scanner sc = new Scanner(System.in)) {
            final PlayerLevelPrinter printer = new PlayerLevelPrinter(System.out);
            final IntRange oneTo100000 = new IntRange(1, 100000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final IntRange oneTo10000 = new IntRange(1, 10000);
            final ConstrainedInteger l = new ConstrainedInteger(sc.nextInt(), oneTo10000);
            final ConstrainedInteger x[] = new ConstrainedInteger[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                x[i] = new ConstrainedInteger(sc.nextInt(), oneTo10000);
            }

            printer.printPlayerLevelAfterBattle(l, x);

            assertEquals("11", out.readLine());
        }
    }

    @Test
    void testprintPlayerLevelAfterBattle2() {
        in.inputln(input2);

        try (Scanner sc = new Scanner(System.in)) {
            final PlayerLevelPrinter printer = new PlayerLevelPrinter(System.out);
            final IntRange oneTo100000 = new IntRange(1, 100000);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100000);
            final IntRange oneTo10000 = new IntRange(1, 10000);
            final ConstrainedInteger l = new ConstrainedInteger(sc.nextInt(), oneTo10000);
            final ConstrainedInteger x[] = new ConstrainedInteger[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                x[i] = new ConstrainedInteger(sc.nextInt(), oneTo10000);
            }

            printer.printPlayerLevelAfterBattle(l, x);

            assertEquals("4", out.readLine());
        }
    }

}
