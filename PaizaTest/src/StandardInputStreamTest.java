import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class StandardInputStreamTest {

    private StandardInputStream in = new StandardInputStream();
    private final String test = "10 4";
    
    @Test
    void testinputln() {
        System.setIn(in);
        in.inputln(test);
        
        try (Scanner sc = new Scanner(System.in)) {
            String result = sc.nextLine();            
            assertEquals(result, "10 4");
            sc.close();
        }
    }

}
