import java.util.Scanner;

class Stdout_primer__variable_array_boss {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final Scanner sc = new Scanner(System.in);
		String[] NandM = getNandM(sc);
		int N = Integer.parseInt(NandM[0]);
		int M = Integer.parseInt(NandM[1]);
		String[] A = getArray(sc);
		String[] B = getArray(sc);
		printA_by_B(A, B);
		
		sc.close();
	}
	
	static String[] getNandM(Scanner sc) {
		String[] result = new String[2];
		String N_M;
		N_M = sc.nextLine();
		result = N_M.split(" ");
		return result;
	}

	static String[] getArray(Scanner sc) {
		String[] result;
		String Number;
		Number = sc.nextLine();
		result = Number.split(" ");
		return result;
	}
	
	static void printA_by_B(String[] A, String[] B) {
		for (int i = 0; i < B.length; i++) {
			printA(A, B[i]);
			A = deleteA(A, B[i]);
		}
	}
	
	static void checkln(int integer, String B) {
		if (integer + 1 == Integer.parseInt(B)) {
			System.out.println();
		} else {
			System.out.print(" ");
		}
	}
	
	static void printA(String[] A, String B) {
		for (int i = 0; i < Integer.parseInt(B); i++) {
			System.out.print(A[i]);
			checkln(i, B);
		}
	}
	
	static String[] deleteA(String[] A, String B) {
		String[] result = new String[A.length - Integer.parseInt(B)];
		for (int i = Integer.parseInt(B); i < A.length; i++) {
			result[i - Integer.parseInt(B)] = A[i];
		}
		return result;
	}
}
