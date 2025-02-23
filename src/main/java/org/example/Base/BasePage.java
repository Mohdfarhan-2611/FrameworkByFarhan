package org.example.Base;

import org.example.Driver.DriverManagerTL;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //constructor
    protected BasePage(){};


    //ClickElement
    public static void ClickElement(By locator){
        WebElement clickElement = DriverManagerTL.getDriver().findElement(locator);
        clickElement.click();
    }

    //SendKeys
    public static void EnterText(By loator, String value) {
        WebElement entertext = DriverManagerTL.getDriver().findElement(loator);
        entertext.sendKeys(value);
    }

    //ClickElementByJS
    public static void ClickElementByJS(By locator)
    {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManagerTL.getDriver());
        WebElement element = DriverManagerTL.getDriver().findElement(locator);
        js.executeScript("arguments[0].click();",element);
    }











    //Wait
    public static void waitVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }








}
