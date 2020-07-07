/* To avoid adding retryAnalyzer for each and every method, we can make use of
 * retrylistener.java class
 * Run this through 'rerunfailed_tests_using_listeners-testng.xml'
 */
package com.testng.runfailedusingretryanalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ClassA1 {

    // To run directly without using XML
    //@Test(retryAnalyzer = RetryAnalyzerTest.class)
    @Test
    public void testCase1() {
        System.out.println("This is test case 1");
        Assert.assertTrue(false);
    }

    @Test
    public void testCase2() {
        System.out.println("This is test case 2");
        Assert.assertTrue(true);
    }
}
