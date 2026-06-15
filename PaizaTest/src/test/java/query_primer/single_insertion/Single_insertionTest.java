package query_primer.single_insertion;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import testcasereader.TestCase;
import testcasereader.TestResources;
import valueobjects.StandardInputStream;
import valueobjects.StandardOutputStream;

class Single_insertionTest {
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
                new TestCase("query_primer.single_insertion/case1.in", "query_primer.single_insertion/case1.out"),
                new TestCase("query_primer.single_insertion/case2.in", "query_primer.single_insertion/case2.out")
                );
    }

    @DisplayName("全体テスト")
    @ParameterizedTest
    @MethodSource("cases")
    void testAll(final TestCase testCase) {
        in.inputText(TestResources.readResourceText(testCase.inputResource));
        Single_insertion.main(null);

        final String expected = TestResources.readResourceText(testCase.expectedResource);
        for (final String line : expected.split("\\R")) {
            assertEquals(line, out.readLine());
        }
    }
    
//    N K Q
//    A_1
//    ...
//    A_N
//
//
//    ・1 行目では、配列 A の要素数 N と整数 K , Q が半角スペース区切りで与えられます。
//    ・続く N 行では、配列 A の要素が先頭から順に与えられます。
//
//    入力値最終行の末尾に改行が１つ入ります。
//    A_1
//    ...
//    A_{N+1}
//
//
//    ・Q を A_K の後ろに挿入した後の配列の各要素を先頭から改行区切りで出力してください。
//    ・また、出力の末尾には改行を入れてください。
//    ・1 ≦ N ≦ 100,000
//    ・1 ≦ K ≦ N
//    ・0 ≦ Q ≦ 100
//    ・0 ≦ A_i ≦ 100 (1 ≦ i ≦ N)
}
