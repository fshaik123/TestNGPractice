// Run using XML file

package com.testng.parallelDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClassD {
    WebDriver driver;

    @Test
    public void testCase1() {
        System.out.println("This is test case 1 : " + Thread.currentThread().getId());
        //setup the chrome using WebDriverManager
        System.setProperty("webdriver.chrome.driver","./webdrivers/chromedriver.exe");

        //Create driver object for Chrome
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testCase2() {
        System.out.println("This is test case 2 : " + Thread.currentThread().getId());
        //setup the chrome using WebDriverManager
        System.setProperty("webdriver.chrome.driver","./webdrivers/chromedriver.exe");

        //Create driver object for Chrome
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
