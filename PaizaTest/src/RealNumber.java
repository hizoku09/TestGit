class RealNumber {
    private static final double MIN = 0.001;
    private static final double MAX = 99.999;
    final double Number;

    RealNumber(final String str) {
        if (str == null) {
            throw new NullPointerException("文字列を指定してください。");
        }

        final double Number = Double.parseDouble(str);
        if (Number < MIN | Number >= MAX) {
            throw new IllegalArgumentException("数値は 0.001 以上もしくは 99.999 未満で入力してください。");
        }

        this.Number = Number;
    }
}
