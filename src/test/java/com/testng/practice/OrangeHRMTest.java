package com.testng.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRMTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Create driver object for Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // alwaysRun makes sure that the method runs even the dependant method fails
    @Test(priority = 1, description = "Launch OrangeHRM App", alwaysRun = true)
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

    // invocationcount is used when you have to execute multiple times
    @Test(priority = 3, dependsOnMethods = {"openURL", "login"}, invocationCount = 3)
    public void verifyCurrentURL() {
        String url = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(url, expectedURL);
    }

    // to ignore a test, you can use @Ignore or use 'enabled' keyword
    @Ignore
    @Test(priority = 4, enabled = false)
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
