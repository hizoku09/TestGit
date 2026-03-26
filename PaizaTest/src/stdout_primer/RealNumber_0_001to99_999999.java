package stdout_primer;

class RealNumber_0_001to99_999999 {

    private static final double MAX = 99.999999;
    private static final double MIN = 0.001;
    final double value;
    
    RealNumber_0_001to99_999999(final double value) {
        illegalcheck(value);
        this.value = value;
    }
    
    void illegalcheck(final double value) {
        if (value < MIN) {
            throw new IllegalArgumentException("数値は " + MIN + " 以上で入力してください。");
        }
        if (value >= MAX) {
            throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。");
        }
    }
    
}
