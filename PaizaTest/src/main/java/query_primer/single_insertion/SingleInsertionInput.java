package query_primer.single_insertion;

import java.util.List;

import valueobjects.ConstrainedInteger;

final class SingleInsertionInput {
    private final ConstrainedInteger elementsN;
    private final ConstrainedInteger insertionIndexK;
    private final ConstrainedInteger insertionValueQ;
    private final List<ConstrainedInteger> sourceValues;
    
    private SingleInsertionInput(
            final ConstrainedInteger elementsN, 
            final ConstrainedInteger insertionIndexK, 
            final ConstrainedInteger insertionValueQ,
            final List<ConstrainedInteger> sourceValues) {
        
        this.elementsN       = elementsN;
        this.insertionIndexK = insertionIndexK;
        this.insertionValueQ = insertionValueQ;
        this.sourceValues    = List.copyOf(sourceValues);;
    }

    static SingleInsertionInput newInstance(
            final ConstrainedInteger elementsN, 
            final ConstrainedInteger insertionIndexK, 
            final ConstrainedInteger insertionValueQ,
            final List<ConstrainedInteger> sourceValues) {
        
        return new SingleInsertionInput(elementsN, insertionIndexK, insertionValueQ, sourceValues);
    }

    ConstrainedInteger elementsN() {
        // TODO 自動生成されたメソッド・スタブ
        return elementsN;
    }

    ConstrainedInteger insertionIndexK() {
        // TODO 自動生成されたメソッド・スタブ
        return insertionIndexK;
    }

    ConstrainedInteger insertionValueQ() {
        // TODO 自動生成されたメソッド・スタブ
        return insertionValueQ;
    }

    List<ConstrainedInteger> sourceValues() {
        // TODO 自動生成されたメソッド・スタブ
        return sourceValues;
    }
}
