package a16dungeon1;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

class A16 {

	public static void main(String[] args) {
		run(System.in, System.out);
	}

	static void run(final InputStream input, final PrintStream output) {
		try (Scanner scanner = new Scanner(input)) {
			final A16InputReader reader = A16InputReader.newInstance(scanner);
			final A16Input inputData = reader.read();
			final A16Calculator calculator = A16Calculator.getInstance();
			final A16Printer printer = A16Printer.newInstance(output);
			
			final int result = calculator.dynamicProgramming(inputData);

			printer.printA16(result);
		}
	}

}
