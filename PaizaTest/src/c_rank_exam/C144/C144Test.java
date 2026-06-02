package c_rank_exam.C144;

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

class C144Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input1 = "6\n"
            + "G C\n"
            + "C G\n"
            + "P G\n"
            + "G C\n"
            + "P P\n"
            + "P C";
    private final String input2 = "8\n"
            + "G C\n"
            + "P C\n"
            + "C G\n"
            + "G C\n"
            + "G P\n"
            + "P G\n"
            + "C C\n"
            + "C P";

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

        C144.main(null);

        assertEquals("3", out.readLine());
    }

    @Test
    @DisplayName("・1 行で過去に行われたじゃんけんの回数を表す整数 N が与えられます。\n"
            + "・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、"
            + "(i 回目のじゃんけんにおいてアリスさんが出した手)、(i 回目のじゃんけんにおいてボブさんが出した手) "
            + "を表す文字列 A_i, B_i がこの順で半角スペース区切りで与えられます。\n"
            + "・入力は合計で N + 1 行となり、末尾に改行が 1 つ入ります。\n"
            + "・じゃんけんの手は「グー」、「チョキ」、「パー」の 3 種類のみであり、それぞれ順番に 'G', 'C', 'P' というアルファベット 1 文字によって表現されます。"
            + "過去に行われたアリスさんとボブさんのじゃんけんの記録を元に、過去にアリスさんがボブさんに何回勝ったかを 1 行で出力してください。\n"
            + "末尾に改行を入れ、余計な文字、空行を含んではいけません。")
    void testprintWinTimesOfRockPaperScissors1() {
        in.inputln(input1);

        try (Scanner sc = new Scanner(System.in)) {
            final RockPaperScissorsResultPrinter printer = new RockPaperScissorsResultPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final String choiceOfAlice[] = new String[n.getValue()];
            final String choiceOfBob[] = new String[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                choiceOfAlice[i] = sc.next();
                choiceOfBob[i] = sc.next();
            }

            printer.printWinTimesOfRockPaperScissors(choiceOfAlice, choiceOfBob);

            assertEquals("3", out.readLine());
        }
    }

    @Test
    void testprintWinTimesOfRockPaperScissors2() {
        in.inputln(input2);

        try (Scanner sc = new Scanner(System.in)) {
            final RockPaperScissorsResultPrinter printer = new RockPaperScissorsResultPrinter(System.out);
            final IntRange oneTo100 = new IntRange(1, 100);
            final ConstrainedInteger n = new ConstrainedInteger(sc.nextInt(), oneTo100);
            final String choiceOfAlice[] = new String[n.getValue()];
            final String choiceOfBob[] = new String[n.getValue()];
            for (int i = 0; i < n.getValue(); i++) {
                choiceOfAlice[i] = sc.next();
                choiceOfBob[i] = sc.next();
            }

            printer.printWinTimesOfRockPaperScissors(choiceOfAlice, choiceOfBob);

            assertEquals("4", out.readLine());
        }
    }

}
