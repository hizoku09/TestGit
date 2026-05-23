package c_rank_skillcheck_sample;

import java.io.PrintStream;

class FizzBuzzPrinter {
    private final PrintStream out;

    FizzBuzzPrinter(final PrintStream out) {
        this.out = out;
    }

    void printFizzBuzz(final int n) {
        final int fizz = n % 3;
        final int buzz = n % 5;
        
        if ((fizz == 0) && (buzz == 0)) {
            out.print("Fizz Buzz\n");
        } else if (fizz == 0) {
            out.print("Fizz\n");
        } else if (buzz == 0) {
            out.print("Buzz\n");
        } else {
            out.printf("%d\n", n);
        }
    }

}
