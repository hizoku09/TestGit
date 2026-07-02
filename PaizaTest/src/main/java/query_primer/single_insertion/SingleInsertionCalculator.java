package query_primer.single_insertion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import valueobjects.ConstrainedInteger;

final class SingleInsertionCalculator {
    private static final SingleInsertionCalculator INSTANCE = new SingleInsertionCalculator();
    private SingleInsertionCalculator() {
        // TODO 自動生成されたコンストラクター・スタブ
    }
    
    public static SingleInsertionCalculator getInstance() {
        return INSTANCE;
    }
    
    List<Integer> insertAt(
            final List<ConstrainedInteger> sourceValues,
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue) {

        final List<Integer> convertInteger = new ArrayList<>();
        
        validateInsertionIndex(insertionIndex, sourceValues.size());
        for (ConstrainedInteger original : sourceValues) {
            convertInteger.add(original.getValue());
        }
        convertInteger.add(insertionIndex.getValue(), insertionValue.getValue());
        final List<Integer> result = Collections.unmodifiableList(convertInteger);

        return result;
    }
    
    private void validateInsertionIndex(
            final ConstrainedInteger insertionIndex,
            final int sourceLength) {

        if (insertionIndex.getValue() < 0 || insertionIndex.getValue() > sourceLength) {
            throw new IllegalArgumentException(
                    "挿入位置は 0 以上 " + sourceLength + " 以下で指定してください。");
        }
    }
}
