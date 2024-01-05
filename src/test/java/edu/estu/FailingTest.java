package edu.estu;

import org.junit.Test;

import static org.junit.Assert.*;

/* *********************************************************
 **** WRITE YOUR FAILING UNIT TEST(S) INTO  THIS FILE! *****
 ***********************************************************
 */

/**
 * Unit tests for the first part of the project.
 */
public class FailingTest {
    // Test case for demonstrating the infinite loop bug
    @Test
    public void testInfiniteLoop() {
        Thread testThread = new Thread(() -> {
            try {
                App.infiniteLoop(Double.POSITIVE_INFINITY);
            } catch (Throwable e) {
                assertTrue(e instanceof StackOverflowError);
            }
        });

        testThread.start();

        // Set a timeout for how long the test should wait for the thread to finish (adjust as needed)
        long timeoutMillis = 5000; // 5 seconds

        try {
            testThread.join(timeoutMillis);
            assertFalse("The method did not complete within the expected time.", testThread.isAlive());
        } catch (InterruptedException e) {
            fail("Test thread was interrupted.");
        }
    }
}
