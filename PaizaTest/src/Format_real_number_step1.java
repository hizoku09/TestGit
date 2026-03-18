class Format_real_number_step1 {
    private static final double MIN = 0.001;
    private static final double MAX = 99.999;
    final double value;

    Format_real_number_step1(final double dbl) {

        if (dbl < MIN | dbl >= MAX) {
            throw new IllegalArgumentException("数値は 0.001 以上もしくは 99.999 未満で入力してください。");
        }

        this.value = dbl;
    }
}
