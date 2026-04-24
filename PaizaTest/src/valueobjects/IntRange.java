package valueobjects;

public final class IntRange {
    private final int minInclusive;
    private final int maxExclusive;

    public IntRange(final int minInclusive, final int maxExclusive) {
        if (minInclusive >= maxExclusive) {
            throw new IllegalArgumentException("最小値は最大値以下に指定してください。");
        }
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }

    public void validate(final int value) {
        if (value < minInclusive) {
            throw new IllegalArgumentException("数値は " + minInclusive + " 以上で入力してください。");
        }
        if (value >= maxExclusive) {
            throw new IllegalArgumentException("数値は " + maxExclusive + " 未満で入力してください。");
        }
    }
}
