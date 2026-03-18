import java.util.Scanner;

class InputReader {
    private final Scanner sc;

    InputReader (final Scanner sc) {
        this.sc = sc;
    }

    String[] readTokensLine() {
        final String line = sc.nextLine().trim();
        if (line.isEmpty()) return new String[0];
        final String[] result = line.split("\\s+");
        return result;
    }
}
