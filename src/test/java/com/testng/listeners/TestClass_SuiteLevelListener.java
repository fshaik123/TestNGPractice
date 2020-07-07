// Implementation at Suite level - Use XML file
package com.testng.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestClass_SuiteLevelListener {

    @Test
    public void testCase5() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase6() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase7() {
        Assert.assertTrue(false);
    }

    // In order to skip this
    @Test(dependsOnMethods = "testCase7")
    public void testCase8() {
        Assert.assertTrue(true);
    }
}
