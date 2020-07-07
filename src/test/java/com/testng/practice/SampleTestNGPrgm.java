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

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestNGPrgm {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Create driver object for Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void getTitle() {
        String title = driver.getTitle();
        System.out.println("Title of the Page is: " + title);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
