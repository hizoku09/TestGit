package exam.c166;

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

class C166Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();
    private final String input1 = "733";
    private final String input2 = "999";

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
        
        C166.main(null);
        
        assertEquals("9", out.readLine());
    }

    @Test
    @DisplayName("X 円の商品を購入しようとしています。あなたは、手持ちの小銭で X 円ちょうどを支払おうとしています。\n"
            + "ここで言う小銭とは、500円硬貨、100円硬貨、50円硬貨、10円硬貨、5円硬貨、1円硬貨、のことを指し、すべての硬貨が十分な枚数あります。\n"
            + "支払いで使う小銭の合計枚数を最も少なくしたとき、何枚の硬貨が必要になるかを出力してください。\n"
            + "入力例 1 の場合、733 円の商品に対して、500円硬貨 1 枚、100円硬貨 2 枚、10円硬貨 3 枚、1 円硬貨 3 枚で支払うことができます。これが最少の小銭の合計枚数なので、9 と出力してください。")
    void testprintCoinCountForPayment1() {
        in.inputln(input1);

        try (Scanner sc = new Scanner(System.in)) {
            final AmountOfCoinsPrinter printer = new AmountOfCoinsPrinter(System.out);
            final IntRange oneTo1000 = new IntRange(1, 1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);

            printer.printCoinCountForPayment(x);

            assertEquals("9", out.readLine());
        }
    }

    @Test
    void testprintCoinCountForPayment2() {
        in.inputln(input2);

        try (Scanner sc = new Scanner(System.in)) {
            final AmountOfCoinsPrinter printer = new AmountOfCoinsPrinter(System.out);
            final IntRange oneTo1000 = new IntRange(1, 1000);
            final ConstrainedInteger x = new ConstrainedInteger(sc.nextInt(), oneTo1000);

            printer.printCoinCountForPayment(x);

            assertEquals("15", out.readLine());
        }
    }

}
