package a16dungeon1;

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

class A16Test {

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
    
    static Stream<testcasereader.TestCase> cases() {
        return Stream.of(
                new TestCase("a16dungeon1/case1.in", "a16dungeon1/case1.out"),
                new TestCase("a16dungeon1/case2.in", "a16dungeon1/case2.out"));
    }

    @DisplayName("全体テスト")
    @ParameterizedTest
    @MethodSource("cases")
    void testAll(final TestCase testCase) {
        in.inputText(TestResources.readResourceText(testCase.inputResource));

        A16.main(null);

        final String expected = TestResources.readResourceText(testCase.expectedResource);
        for (final String line : expected.split("\\R")) {
            assertEquals(line, out.readLine());
        }
    }

}
