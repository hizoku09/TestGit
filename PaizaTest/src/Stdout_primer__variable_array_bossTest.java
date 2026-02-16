import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class Stdout_primer__variable_array_bossTest {
	private StandardInputStream in = new StandardInputStream();
	private StandardOutputStream out = new StandardOutputStream();
	private final String N_M = "10 4";
	private final String A = "1 2 3 4 5 6 7 8 9 10";
	private final String B = "2 6 1 1";

	@BeforeEach
	void before() {
		System.setIn(in);
		System.setOut(out);
		in.inputln(N_M);
		in.inputln(A);
		in.inputln(B);
	}
	
	@AfterEach
	void after() {
		System.setIn(null);
		System.setOut(null);
	}
	
	@Test
	@DisplayName("全体テスト")
	void testAll() {
		Stdout_primer__variable_array_boss.main(null);
		String[] Answer = new String[]{"1 2", "3 4 5 6 7 8", "9", "10"};
		for (String test : Answer) {
			assertEquals(test, out.readLine());
		}
	}
	
	// 標準入力から整数 N と、 M を受け取る
	// 標準入力から文字列 N_value を受け取り、配列 NArray 配列に代入して返す。半角スペース区切り
	// 標準入力から文字列 M_value を受け取り、配列 MArray 配列に代入して返す。半角スペース区切り
	// 引数 NArray と MArray を受け取る。 MArray[i] の値分、 NArray[] の要素を標準出力する
	@Test
	@DisplayName("標準入力から整数N/M, 数列A/Bを受け取る。配列Aと配列Bに代入して返す。半角スペース区切り")
	void testgetN_M() {
		Stdout_primer__variable_array_boss boss = new Stdout_primer__variable_array_boss();
		Scanner sc = new Scanner(System.in);
		
		String[] NandM = boss.getNandM(sc);
		int N = Integer.parseInt(NandM[0]);
		int M = Integer.parseInt(NandM[1]);
		assertEquals(N, 10);
		assertEquals(M, 4);
		
		String[] A = boss.getArray(sc);
		int[] Atest = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		for (int i = 0; i < A.length; i++) {
			assertEquals(Atest[i], Integer.parseInt(A[i]));
		}
		
		String[] B = boss.getArray(sc);
		int[] Btest = new int[]{2, 6, 1, 1};
		for (int i = 0; i < B.length; i++) {
			assertEquals(Btest[i], Integer.parseInt(B[i]));
		}
		
		sc.close();
	}
		
	@Test
	@DisplayName("引数A[] とB[] を受け取る。 B[] の値分、A[] の要素を標準出力する")
	void testprintA_by_B() {
		Stdout_primer__variable_array_boss boss = new Stdout_primer__variable_array_boss();
		Scanner sc = new Scanner(System.in);
		String[] N_M = boss.getNandM(sc);
		String[] A = boss.getArray(sc);
		String[] B = boss.getArray(sc);
		String[] Answer = new String[]{"1 2", "3 4 5 6 7 8", "9", "10"};
		
		boss.printA_by_B(A, B);
		for (String test : Answer) {
			assertEquals(test, out.readLine());
		}
		sc.close();
	}
	
	@Test
	@DisplayName("引数A[] , B を受け取る。Bの値分、A[] の要素を標準出力する")
	void testprintA() {
		Stdout_primer__variable_array_boss boss = new Stdout_primer__variable_array_boss();
		String[] A = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String B = "2";
		String[] Answer = new String[] {"1 2"};
		
		boss.printA(A, B);
		for (String test : Answer) {
			assertEquals(test, out.readLine());
		}
	}
	
	@Test
	@DisplayName("引数int integer , String B を受け取る。"
			+ "integer + 1 == B なら改行を、そうでないなら半角スペースを出力する")
	void testcheckln() {
		Stdout_primer__variable_array_boss boss = new Stdout_primer__variable_array_boss();
		int integer = 0;
		String B = "2";
		
		boss.checkln(integer, B);
		assertEquals(" ", out.readLine());
		
		integer = 1;
		boss.checkln(integer, B);
		assertEquals("", out.readLine());
		
		integer = 2;
		boss.checkln(integer, B);
		assertEquals(" ", out.readLine());
	}
	
	@Test
	@DisplayName("引数A[] , B を受け取る。Bの値分、A[] の先頭から要素を取り除き、"
			+ "残りの文字列をコピーして返す")
	void testdeleteA() {
		Stdout_primer__variable_array_boss boss = new Stdout_primer__variable_array_boss();
		String[] A = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String B = "2";
		String[] Answer = new String[] {"3", "4", "5", "6", "7", "8", "9", "10"};
		
		A = boss.deleteA(A, B);
		assertArrayEquals(Answer, A);
	}
}
