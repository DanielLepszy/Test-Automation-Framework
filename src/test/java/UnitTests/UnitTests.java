package UnitTests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UnitTests {

    @Test
    public void testCollections() {

        ArrayList<Integer> yy = new ArrayList<>();
        ArrayList<Integer> yy2 = new ArrayList<>();
        yy.add(1);
        yy.add(2);
        yy2.add(1);
        yy2.add(2);

        assertEquals(yy, yy2);

    }

}
