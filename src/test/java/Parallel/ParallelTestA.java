package Parallel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

@DisplayName("Test Class Two")
@ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
public class ParallelTestA {

    @Test
    @DisplayName("C2 M1")
    void testOne() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("Test class two, test one: " + System.currentTimeMillis());
        Assertions.assertTrue(true);
    }
    @Test
    @DisplayName("C2 M2")
    void testTwo() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println("Test class two, test two: " + System.currentTimeMillis());
        Assertions.assertTrue(true);
    }
}