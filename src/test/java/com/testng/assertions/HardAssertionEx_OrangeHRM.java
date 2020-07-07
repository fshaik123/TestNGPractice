/* Hard Assertion(Assert)
 *      Hard Assertion is used when a test has to stop immediately after assertion fails
 * Methods in Hard Assertion
 *      i) assertEquals
 *      ii) assertNotEquals
 *      iii) assertTrue
 *      iv) assertFalse
 *      v) assertNull
 *      vi) assertNotNull
 */
package com.testng.assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HardAssertionEx_OrangeHRM {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Create driver object for Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Launch OrangeHRM App")
    public void openURL() {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
        boolean img = driver.findElement(By.xpath("//*[@id='divLogo']/img")).isDisplayed();
        Assert.assertTrue(img);
    }

    @Test(priority = 2)
    public void login() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        boolean img1 = driver.findElement(By.xpath("//*[@id='branding']/a[1]/img")).isDisplayed();
        Assert.assertTrue(img1);
    }

    @Test(priority = 3)
    public void verifyCurrentURL() {
        String url = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertNotEquals(url, expectedURL);
    }

    @Test(priority = 4)
    public void verifyTitle() {
        String title = driver.getTitle();
        String expectedTitle = "OrangeHRM";
        Assert.assertEquals(title, expectedTitle);
    }

    @Test(priority = 5, dependsOnMethods = {"openURL"})
    public void logout() throws InterruptedException {
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(2000);
        String expectedURL1 = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        String actualURL1 = driver.getCurrentUrl();
        Assert.assertEquals(actualURL1, expectedURL1);
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}
