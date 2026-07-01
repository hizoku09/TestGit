package query_primer.single_insertion;

import java.util.ArrayList;
import java.util.List;

import valueobjects.ConstrainedInteger;

final class SingleInsertionCalculator {
    List<Integer> insertAt(
            final List<ConstrainedInteger> sourceValues,
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue) {

        final List<Integer> result = new ArrayList<Integer>();
        
        validateInsertionIndex(insertionIndex, sourceValues.size());
        for (ConstrainedInteger original : sourceValues) {
            result.add(original.getValue());
        }
        result.add(insertionIndex.getValue(), insertionValue.getValue());

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
