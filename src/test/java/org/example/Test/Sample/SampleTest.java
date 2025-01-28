package org.example.Test.Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTest {



    @Test
    public static void LaunchURL()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--Incognito");
        chromeOptions.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);


        driver.get("https://admin-preprod.avibra.com/login");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("kumarsanjay2001us@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("c0dpiI#8");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='profile profile-header-style col']//button"))).click();
        driver.findElement(By.xpath("//div[@class='popover-body']//a")).click();


        driver.quit();

    }
}
