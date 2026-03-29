package stdout_primer;

class NaturalNumber_1to100 {

    private static final int MAX = 101;
    private static final int MIN = 1;
    final int value;

    NaturalNumber_1to100(final int value) {
        illegalcheck(value);
        this.value = value;
    }

    void illegalcheck(final int value) {
        if (value < MIN) {
            throw new IllegalArgumentException("数値は " + MIN + " 以上で入力してください。");
        }
        if (value >= MAX) {
            throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。");
        }
    }

}
