package query_primer.single_insertion;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import valueobjects.ConstrainedInteger;
import valueobjects.IntRange;

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
        try (Scanner sc = new Scanner(input)) {
            final SingleInsertionCalculator calculator = SingleInsertionCalculator.getInstance();
            final SingleInsertionPrinter printer = SingleInsertionPrinter.newInstance(output);
            final IntRange oneTo100_000 = new IntRange(1, 100_000);
            final ConstrainedInteger elementsN = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final ConstrainedInteger insertionIndexK = new ConstrainedInteger(sc.nextInt(), oneTo100_000);
            final IntRange zeroTo100 = new IntRange(0, 100);
            final ConstrainedInteger insertionValueQ = new ConstrainedInteger(sc.nextInt(), zeroTo100);
            final List<ConstrainedInteger> listA = new ArrayList<>();
            for (int i = 0; i < elementsN.getValue(); i++) {
                listA.add(new ConstrainedInteger(sc.nextInt(), zeroTo100));
            }

            final List<Integer> result = calculator.insertAt(listA, insertionIndexK, insertionValueQ);
            printer.printSingleInsertion(result);
        }
    }

}
