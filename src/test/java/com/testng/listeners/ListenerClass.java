/* Listener: Listeners 'listen' to the event defined in the selenium script and
 *              behave accordingly
 * Purpose of Listeners: Listeners are used in selenium to generate logs or customize
 *                          the TestNG reports
 * Types:
 *      1) WebDriver Listeners - events triggered by webdriver
 *      2) TestNG Listeners - events triggered by TestNG
 *
 *  Links - https://www.lambdatest.com/blog/testng-listeners-in-selenium-webdriver-with-examples/
 *          https://www.toolsqa.com/testng/testng-listeners/
 */
package com.testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Method " + iTestResult.getName() + " Starts");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Method " + iTestResult.getName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Method " + iTestResult.getName() + " Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Method " + iTestResult.getName() + " Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test " + iTestContext.getName() + " Starts");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Test " + iTestContext.getName() + " Ends");
    }
}
