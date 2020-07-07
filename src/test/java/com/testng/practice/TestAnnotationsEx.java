/*  TESTNG Annotations Heirarchy
 *  @BeforeSuite
 *      @BeforeTest
 *          @BeforeClass
 *              @BeforeMethod
 *                  @Test
 *              @AfterMethod
 *          @AfterClass
 *      @AfterTest
 *  @AfterSuite
 */
package com.testng.practice;

import org.testng.annotations.*;

public class TestAnnotationsEx {

    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("Before suite is executed");
    }

    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println("After Suite is executed");
    }

    @BeforeTest
    public void beforeTestMethod(){
        System.out.println("Before Test is executed");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("After Test is executed");
    }

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("Before class is executed");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class is executed");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method is executed");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method is executed");
    }

    @Test(groups = {"Smoke"})
    public void testMethod1() {
        System.out.println("Test Method 1 is executed");
    }

    @Test(groups = {"Regression"})
    public void testMethod2() {
        System.out.println("Test Method 2 is executed");
    }
}
