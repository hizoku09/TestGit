package query_primer.single_insertion;

import java.util.List;

import valueobjects.ConstrainedInteger;

final class SingleInsertionInput {
    private final IntegerElementsN       elementsN;
    private final IntegerInsertionIndexK insertionIndexK;
    private final IntegerInsertionValueQ insertionValueQ;
    private final List<ConstrainedInteger> sourceValues;
    
    private SingleInsertionInput(
            final IntegerElementsN       elementsN, 
            final IntegerInsertionIndexK insertionIndexK, 
            final IntegerInsertionValueQ insertionValueQ,
            final List<ConstrainedInteger> sourceValues) {
        
        this.elementsN       = elementsN;
        this.insertionIndexK = insertionIndexK;
        this.insertionValueQ = insertionValueQ;
        this.sourceValues    = List.copyOf(sourceValues);
    }

    static SingleInsertionInput newInstance(
            final IntegerElementsN       elementsN, 
            final IntegerInsertionIndexK insertionIndexK, 
            final IntegerInsertionValueQ insertionValueQ,
            final List<ConstrainedInteger> sourceValues) {
        
        return new SingleInsertionInput(elementsN, insertionIndexK, insertionValueQ, sourceValues);
    }

    IntegerElementsN elementsN() {
        return elementsN;
    }

    IntegerInsertionIndexK insertionIndexK() {
        return insertionIndexK;
    }

    IntegerInsertionValueQ insertionValueQ() {
        return insertionValueQ;
    }

    List<ConstrainedInteger> sourceValues() {
        return sourceValues;
    }
}
