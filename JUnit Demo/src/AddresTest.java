import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddresTest {
    @Test
    public void doRandomTest(){
        int a = 10;
        int b = 10;
        int realSum = 20;
        Addre addre = new Addre();
        int expectedSum = addre.add(a,b);
        assertEquals(realSum, expectedSum);
    }
}
