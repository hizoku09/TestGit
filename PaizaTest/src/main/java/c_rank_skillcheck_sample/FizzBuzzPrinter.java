package c_rank_skillcheck_sample;

import java.io.PrintStream;

class FizzBuzzPrinter {
    private final PrintStream out;

    FizzBuzzPrinter(final PrintStream out) {
        this.out = out;
    }

    void printFizzBuzz(final int n) {
        if (isFizz(n) && isBuzz(n)) {
            out.print("Fizz Buzz\n");
        } else if (isFizz(n)) {
            out.print("Fizz\n");
        } else if (isBuzz(n)) {
            out.print("Buzz\n");
        } else {
            out.printf("%d\n", n);
        }
    }

    boolean isBuzz(final int n) {
        final int buzz = n % 5;
        return buzz == 0;
    }

    boolean isFizz(final int n) {
        final int fizz = n % 3;
        return fizz == 0;
    }

}
