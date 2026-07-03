package query_primer.single_insertion;

import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import testcasereader.TestCase;
import testcasereader.TestResources;
import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;
import valueobjects.StandardInputStream;
import valueobjects.StandardOutputStream;

class SingleInsertionTest {
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
                new TestCase("query_primer.single_insertion/case2.in", "query_primer.single_insertion/case2.out"));
    }

    @DisplayName("全体テスト")
    @ParameterizedTest
    @MethodSource("cases")
    void testAll(final TestCase testCase) {
        in.inputText(TestResources.readResourceText(testCase.inputResource));

        SingleInsertion.main(null);

        final String expected = TestResources.readResourceText(testCase.expectedResource);
        for (final String line : expected.split("\\R")) {
            assertEquals(line, out.readLine());
        }
    }

    @Test
    @DisplayName("標準入力オブジェクトテスト")
    void holdsSingleValues() {
        final IntRange oneTo100_000 = new IntRange(1, 100_000);
        final IntRange zeroTo100 = new IntRange(0, 100);
        final List<ConstrainedInteger> sourceValues =
                List.of(new ConstrainedInteger(17, zeroTo100),
                        new ConstrainedInteger(57, zeroTo100),
                        new ConstrainedInteger(83, zeroTo100));
        final SingleInsertionInput input = SingleInsertionInput.newInstance(
                new ConstrainedInteger(3, oneTo100_000),
                new ConstrainedInteger(1, oneTo100_000), 
                new ConstrainedInteger(57, zeroTo100),
                sourceValues);

        assertEquals( 3, input.elementsN().getValue());
        assertEquals( 1, input.insertionIndexK().getValue());
        assertEquals(57, input.insertionValueQ().getValue());
        assertEquals( 3, input.sourceValues().size());
        assertEquals(17, input.sourceValues().get(0).getValue());
        assertEquals(57, input.sourceValues().get(1).getValue());
        assertEquals(83, input.sourceValues().get(2).getValue());
    }
    
    @Test
    @DisplayName("標準入力取得テスト")
    void fetchesAllInputValues() {
        in.inputText("""
                3 1 57
                17
                57
                83
                """);

        try (Scanner scanner = new Scanner(in)) {
            final SingleInsertionInputReader fetcher = SingleInsertionInputReader.newInstance(scanner);
            final SingleInsertionInput actual = fetcher.read();

            assertEquals( 3, actual.elementsN().getValue());
            assertEquals( 1, actual.insertionIndexK().getValue());
            assertEquals(57, actual.insertionValueQ().getValue());
            assertEquals( 3, actual.sourceValues().size());
            assertEquals(17, actual.sourceValues().get(0).getValue());
            assertEquals(57, actual.sourceValues().get(1).getValue());
            assertEquals(83, actual.sourceValues().get(2).getValue());
        }
    }

    @Test
    @DisplayName("学習用テスト List")
    void testList() {
        final List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        final int[] expected = { 1, 2, 3 };
        for (int i = 0; i < 3; i++) {
            assertEquals(test.get(i), expected[i]);
        }
    }

    @Test
    @DisplayName("学習用テスト2 List")
    void testConstrainedIntegerList() {
        final List<ConstrainedInteger> test = new ArrayList<ConstrainedInteger>();
        final IntRange zeroTo100 = new IntRange(0, 100);
        test.add(new ConstrainedInteger(1, zeroTo100));
        test.add(new ConstrainedInteger(2, zeroTo100));
        test.add(new ConstrainedInteger(3, zeroTo100));
        final List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        for (int i = 0; i < 3; i++) {
            assertEquals(test.get(i).getValue(), expected.get(i));
        }
    }

}
