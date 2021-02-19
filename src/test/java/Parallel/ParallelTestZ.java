package Parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;


@DisplayName("Test Class One")
@ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
public class ParallelTestZ {

    @Test
    @DisplayName("C1 M1")
    void testOne() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Test class one, test one: " + System.currentTimeMillis());

        Assertions.assertTrue(true);

    }
    @Test
    @DisplayName("C1 M2")
    void testTwo() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Test class one, test two: " + System.currentTimeMillis());

        Assertions.assertTrue(true);

    }
}
