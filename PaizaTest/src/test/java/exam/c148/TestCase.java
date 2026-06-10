package exam.c148;

final class TestCase {
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