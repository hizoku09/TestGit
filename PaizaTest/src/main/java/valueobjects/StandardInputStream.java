package valueobjects;

import java.io.InputStream;

public class StandardInputStream extends InputStream {
    // このクラスはテスト用に標準入力(System.in)へ流すデータを保持するInputStream。
    // Scannerで読む責務は別クラス(入力リーダ)に寄せる。

    private final StringBuilder sb = new StringBuilder();
    private final String lf = System.lineSeparator();

    /**
     * 文字列を入力する。改行は自動的に行う
     * 
     * @param str 入力文字列
     */
    public void inputln(String str) {
        if (str == null) str = "null";
        sb.append(str).append(lf);
    }

    @Override
    public int read() {
        if (sb.length() == 0)
            return -1;
        int result = sb.charAt(0);
        sb.deleteCharAt(0);
        return result;
    }
 
}
