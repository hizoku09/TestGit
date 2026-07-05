package query_primer.single_insertion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import valueobjects.ConstrainedInteger;

final class SingleInsertionCalculator {
    private static final SingleInsertionCalculator INSTANCE = new SingleInsertionCalculator();
    private SingleInsertionCalculator() {}
    
    static SingleInsertionCalculator getInstance() {
        return INSTANCE;
    }
    
    List<Integer> insertAt(
            final IntegerInsertionIndexK insertionIndex,
            final IntegerInsertionValueQ insertionValue,
            final List<ConstrainedInteger> sourceValues) {

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
            final IntegerInsertionIndexK insertionIndex,
            final int sourceLength) {

        if (insertionIndex.getValue() < 0 || insertionIndex.getValue() > sourceLength) {
            throw new IllegalArgumentException(
                    "挿入位置は 0 以上 " + sourceLength + " 以下で指定してください。");
        }
    }
}
