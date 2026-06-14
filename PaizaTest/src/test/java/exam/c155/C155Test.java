package exam.c155;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import exam.testcasereader.TestCase;
import exam.testcasereader.TestResources;
import valueobjects.StandardInputStream;
import valueobjects.StandardOutputStream;

class C155Test {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final StandardInputStream in = new StandardInputStream();
    private final StandardOutputStream out = new StandardOutputStream();

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
        return Stream.of(
                new TestCase("c155/case1.in", "c155/case1.out"),
                new TestCase("c155/case2.in", "c155/case2.out")
                );
    }

    @DisplayName("全体テスト")
    @ParameterizedTest
    @MethodSource("cases")
    void testAll(final TestCase testCase) {
        in.inputText(TestResources.readResourceText(testCase.inputResource));
        C155.main(null);

        final String expected = TestResources.readResourceText(testCase.expectedResource);
        for (final String line : expected.split("\\R")) {
            assertEquals(line, out.readLine());
        }
    }

//    入力は以下のフォーマットで与えられます。
//
//    S
//    N
//    T_1
//    ...
//    T_N
//    ・1 行目に広告と判定するワード S が与えられます。
//    ・2 行目にメールの件数 N が与えられます。
//    ・続く N 行の i 行目 (1 ≦ i ≦ N)には、i 番目のメールのタイトル T_i が与えられます。
//    ・入力は合計で N+2 行からなり、入力値最終行の末尾に改行が 1 つ入ります。
//    各メールのタイトルが広告と判定されたか否かを、次の形式で出力してください。
//    R_1
//    ...
//    R_N
//    ・期待する出力は N 行からなります。
//    ・R_i (1 ≦ i ≦ N) は i 番目のメールに対応し、各メールのタイトルが広告と判定されたとき、R_i を "Yes" とし、広告と判定されなかったときは "No" としてください。
//    すべてのテストケースにおいて、以下の条件をみたします。
//
//    ・1 ≦ (S の長さ) ≦ 20
//    ・S は半角英数字からなる文字列
//    ・1 ≦ N ≦ 100
//    ・各 1 ≦ i ≦ N に対して
//    　・1 ≦ (T_i の長さ) ≦ 100
//    　・T_i は半角英数字と半角記号 " ", "!", "?", "$", ":" からなる文字列
}
