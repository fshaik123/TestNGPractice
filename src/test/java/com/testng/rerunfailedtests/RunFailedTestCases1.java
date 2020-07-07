// Run using XML file

package com.testng.rerunfailedtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RunFailedTestCases1 {

    @Test
    public void testCase1() {
        System.out.println("This is test case 1");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase2() {
        System.out.println("This is test case 2");
        Assert.assertTrue(false);
    }
}
