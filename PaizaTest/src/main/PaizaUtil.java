package main;
import java.util.Arrays;
import java.util.List;

public class PaizaUtil {
	
	/* getStdinString() を実装するときは、 Scanner を別箇所で宣言する。
	 * それを呼ぶようにする。
	 * 上記のまま実装すると、 try 句が終わると Scanner で読み込んだ
	 * 標準入力の全文字列が廃棄されてしまうため。
	 private static final Scanner sc = new Scanner(System.in);
	 String getStdinString() {
		 String result = sc.nextLine();
		 return result;
	 }
	 */
	
	/**
	 * 受け取った String を、半角スペースで分割し、 List に代入して返す
	 * @param str
	 * @return List<String> result
	 */
	public List<String> splitString(String str) {
		List<String> result = Arrays.asList(str.split(" "));
		return result;
	}
	
	/**
	 * 受け取った String:operand を、String:operator で分割し、 List に代入して返す
	 * @param operand operator
	 * @return List<String> result
	 */
	public List<String> splitStringby(String operand, String operator) {
		List<String> result = Arrays.asList(operand.split(operator));
		return result;
	}
	
	/**
	 * 受け取った List<String> を個別に標準出力する
	 */
	public void printlnStdoutList(List<String> str) {
		for (String result : str) {
			System.out.println(result);
		}
	}
}
