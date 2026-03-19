package main;
class IllegalCheck_format_real_number_step2 implements RealNumber{
    private static final double MAX = 999999999999.999;
    private static final double MIN = 0.001;
    private final double value;
    
    IllegalCheck_format_real_number_step2(final double value) {
        IllegalCheck(value);
        this.value = value;
    }
    
    public void IllegalCheck(final double value) {
        if (value < MIN | value >= MAX) {
            throw new IllegalArgumentException("数値は 0.001 以上もしくは 999999999999.999 未満で入力してください。");
        }
    }
    
    public double getValue() {
        return value;
    }
}
