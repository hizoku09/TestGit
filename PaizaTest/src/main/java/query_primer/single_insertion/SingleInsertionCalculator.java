package query_primer.single_insertion;

import valueobjects.ConstrainedInteger;

final class SingleInsertionCalculator {
    int[] insertAt(
            final ConstrainedInteger[] sourceValues,
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue) {

        validateInsertionIndex(insertionIndex, sourceValues.length);
        final int[] result = new int[sourceValues.length + 1];

        for (int index = 0; index < result.length; index++) {
            result[index] = valueAt(
                    sourceValues, insertionIndex, insertionValue, index);
        }

        return result;
    }
    
    private int valueAt(
            final ConstrainedInteger[] sourceValues,
            final ConstrainedInteger insertionIndex,
            final ConstrainedInteger insertionValue,
            final int index) {

        if (index < insertionIndex.getValue()) {
            return sourceValues[index].getValue();
        }

        if (index == insertionIndex.getValue()) {
            return insertionValue.getValue();
        }

        return sourceValues[index - 1].getValue();
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
