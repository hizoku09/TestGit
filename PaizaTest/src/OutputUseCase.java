import java.util.Arrays;

class OutputUseCase {
    private final OutputWriter writer;

    OutputUseCase(final OutputWriter writer) {
        this.writer = writer;
    }

    void execute(final String[] A, final String[] B) {
        int index = 0;

        for (String bStr : B) {
            int b = Integer.parseInt(bStr);
            String[] chunk = Arrays.copyOfRange(A, index, index + b);
            writer.printlnTokens(chunk);
            index += b;
        }
    }

}
