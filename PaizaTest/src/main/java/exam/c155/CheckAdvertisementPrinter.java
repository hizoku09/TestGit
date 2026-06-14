package exam.c155;

import java.io.PrintStream;

final class CheckAdvertisementPrinter {
    private final PrintStream out;

    CheckAdvertisementPrinter(final PrintStream out) {
        this.out = out;
    }

    void printCheckAdvertisement(final String targetWord, final String[] checkLines) {
        for (final String line : checkLines) {
            if (line.contains(targetWord))
                out.println("Yes");
            else {
                out.println("No");
            }
        }
    }

}
