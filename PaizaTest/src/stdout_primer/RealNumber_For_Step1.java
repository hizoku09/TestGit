package stdout_primer;
class RealNumber_For_Step1 {
    private static final double MAX = 99.999;
    private static final double MIN = 0.001;
    final double value;
    
    RealNumber_For_Step1(final double value) {
        IllegalCheck(value);
        this.value = value;
    }
    
    public void IllegalCheck(final double value) {
        if (value < MIN) {
            throw new IllegalArgumentException("数値は " + MIN + " 以上で入力してください。");
        }
        if (value >= MAX) {
            throw new IllegalArgumentException("数値は " + MAX + " 未満で入力してください。");
        }
    }

}
