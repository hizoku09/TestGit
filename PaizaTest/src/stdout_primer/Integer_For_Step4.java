package stdout_primer;

class Integer_For_Step4 {

    private static final int MAX = 5;
    private static final int MIN = 1;
    final int value;

    Integer_For_Step4(final int value) {
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
