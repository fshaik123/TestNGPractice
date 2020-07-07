// Run using XML file

package com.testng.CrossBrowserDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    WebDriver driver;

    @Parameters("Browser")
    @Test
    public void launchApp(String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else {
            System.out.println("No supported Browser is given");
        }
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        Thread.sleep(2000);
        driver.quit();
    }
}
