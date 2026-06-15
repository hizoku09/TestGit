package testcasereader;

public final class TestCase {
    public final String inputResource;
    public final String expectedResource;

    public TestCase(final String inputResource, final String expectedResource) {
        this.inputResource = inputResource;
        this.expectedResource = expectedResource;
    }

    @Override
    public String toString() {
        return inputResource;
    }
}