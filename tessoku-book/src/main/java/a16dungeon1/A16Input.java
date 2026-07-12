package a16dungeon1;

import java.util.List;

import valueobjects.ConstrainedInteger;

final class A16Input {
	private final IntegerElementsN elementsN; 
	private final List<ConstrainedInteger> arrayA;
	private final List<ConstrainedInteger> arrayB;
	
	private A16Input(
			final IntegerElementsN elementsN, 
			final List<ConstrainedInteger> arrayA,
			final List<ConstrainedInteger> arrayB) {
		
		this.elementsN = elementsN;
		this.arrayA = arrayA;
		this.arrayB = arrayB;
	}

	static A16Input newInstance(
			final IntegerElementsN elementsN, 
			final List<ConstrainedInteger> arrayA,
			final List<ConstrainedInteger> arrayB) {
		
		return new A16Input(elementsN, arrayA, arrayB);
	}
	
	IntegerElementsN elementsN() {
        return elementsN;
    }

	List<ConstrainedInteger> arrayA() {
        return arrayA;
    }

	List<ConstrainedInteger> arrayB() {
        return arrayB;
    }

}
