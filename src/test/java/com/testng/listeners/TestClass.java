package com.testng.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// Implementation at Class level
@Listeners(ListenerClass.class)
public class TestClass {

    @Test
    public void testCase1() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase2() {
        Assert.assertTrue(true);
    }

    @Test
    public void testCase3() {
        Assert.assertTrue(false);
    }

    // In order to skip this
    @Test(dependsOnMethods = "testCase3")
    public void testCase4() {
        Assert.assertTrue(true);
    }
}
