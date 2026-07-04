package query_primer.single_insertion;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

class SingleInsertion {
    public static void main(String[] args) {
        run(System.in, System.out);
    }
    
//  N K Q
//  A_1
//  ...
//  A_N
//
//
//  ・1 行目では、配列 A の要素数 N と整数 K , Q が半角スペース区切りで与えられます。
//  ・続く N 行では、配列 A の要素が先頭から順に与えられます。
//
//  入力値最終行の末尾に改行が１つ入ります。
//  A_1
//  ...
//  A_{N+1}
//
//
//  ・Q を A_K の後ろに挿入した後の配列の各要素を先頭から改行区切りで出力してください。
//  ・また、出力の末尾には改行を入れてください。
//  ・1 ≦ N ≦ 100,000
//  ・1 ≦ K ≦ N
//  ・0 ≦ Q ≦ 100
//  ・0 ≦ A_i ≦ 100 (1 ≦ i ≦ N)

    static void run(final InputStream input, final PrintStream output) {
        try (Scanner scanner = new Scanner(input)) {
            final SingleInsertionInputReader    reader     = SingleInsertionInputReader.newInstance(scanner);
            final SingleInsertionInput          inputData  = reader.read();
            final SingleInsertionCalculator     calculator = SingleInsertionCalculator.getInstance();
            final SingleInsertionPrinter        printer    = SingleInsertionPrinter.newInstance(output);
            
            final List<Integer> result = calculator.insertAt(
                    inputData.insertionIndexK(),
                    inputData.insertionValueQ(),
                    inputData.sourceValues());

            printer.printSingleInsertion(result);
        }
    }

}
