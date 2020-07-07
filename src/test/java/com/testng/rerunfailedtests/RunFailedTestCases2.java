// Run using XML file

package com.testng.rerunfailedtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RunFailedTestCases2 {

    @Test
    public void testCase3() {
        System.out.println("This is test case 3");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase4() {
        System.out.println("This is test case 4");
        Assert.assertTrue(false);
    }
}
