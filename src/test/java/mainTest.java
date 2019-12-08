import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.*;


public class mainTest {

    double epsilon = 0.0000001;

    @Test
    public void evaluateExpression(){
        Tdd a = new Tdd();
        Assertions.assertEquals(7, a.cal(2, 5));
    }

}