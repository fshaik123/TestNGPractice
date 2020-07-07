/* Parameterization: Allows us to run a test case automatically multiple times with
 *                  different input values
 * Two ways to achieve parameterization in TestNG
 *  1. With the help of Parameters annotation and TestNG XML file
 *  2. With the help of DataProvider annotation
 *
 */
package com.testng.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProvider_OrangeHRMTest {

    WebDriver driver;

    @DataProvider(name = "test1")
    public static Object[][] loginCredentials() {
        return new Object[][]{{"admin", "admin123"}, {"admin", "admin123"}, {"123", "12"}};
    }

    @BeforeMethod
    public void setup() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Create driver object for Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
    }

    @Test(dataProvider = "test1", priority = 2)
    public void login(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.name("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        boolean img1 = driver.findElement(By.xpath("//*[@id='branding']/a[1]/img")).isDisplayed();
        Assert.assertTrue(img1);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
