package stdout_primer;
import java.util.Scanner;

class Variable_array_boss {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        try (Scanner sc = new Scanner(System.in)) {
            InputReader reader = new InputReader(sc);
            String[] NandM = reader.readTokensLine();
            int N = Integer.parseInt(NandM[0]);
            int M = Integer.parseInt(NandM[1]);
            String[] A = reader.readTokensLine();
            String[] B = reader.readTokensLine();

            OutputWriter writer = new OutputWriter(System.out);
            OutputUseCase useCase = new OutputUseCase(writer);
            useCase.execute(A, B);
        }
    }
}