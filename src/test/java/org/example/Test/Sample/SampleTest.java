package org.example.Test.Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTest {


    @Test
    public void LoginLogout()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        //Explicitwait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Launch URL
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");

        //Click LoginLink on hompe page
        WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains(text(),'Login')]")));
        loginlink.click();

        //enter the usernametext
        WebElement usernametext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        usernametext.sendKeys("mhdfarhan2611@gmail.com");

        //enter the password
        WebElement passwordtext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordtext.sendKeys("Acc0@mf#7");

        //Click LogintoQKart button
        WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]")));
        loginbutton.click();


        //Click logout link
        WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='primary' and contains(text(),'Logout')]")));
        logout.click();

        //Verify user is again on the homepage and login link display
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains(text(),'Login')]")));
        boolean isDisplayed = login.isDisplayed();
        Assert.assertTrue(isDisplayed);

        //close the browser
        driver.quit();

    }
}
