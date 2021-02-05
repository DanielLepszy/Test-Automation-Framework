import org.junit.jupiter.api.Test;

import java.util.Collection;

public class TestClass {

    @Test
    public void testMethod(){

        Collection<Object> x = System.getProperties().values();
        System.out.println(x);
    }
}
