package a16dungeon1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class A16Calculator {
	private static final A16Calculator INSTANCE = new A16Calculator();
    private A16Calculator() {}
    
    static A16Calculator getInstance() {
        return INSTANCE;
    }
    
    int dynamicProgramming(A16Input inputData) {
        final List<Integer> dynamicProgramming = new ArrayList<>();
        dynamicProgramming.add(0);
        dynamicProgramming.add(inputData.arrayA().get(0).getValue());
        
        for (int i = 3; i <= inputData.elementsN().getValue(); i++) {
            dynamicProgramming.add(Math.min(dynamicProgramming, i));
        }
        final List<Integer> result = Collections.unmodifiableList(dynamicProgramming);

        return result;
    }

}
