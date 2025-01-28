package org.example.Base;

import org.example.Driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class commonToAllPages {

    //Click Element
    protected void ClickElement(By elementlocation) {
        WebElement element = DriverManager.getDriver().findElement(elementlocation);
        element.click();
    }

    //SendKeys
    protected void EnterText(By elementlocation, String text) {
        WebElement element = DriverManager.getDriver().findElement(elementlocation);
        element.sendKeys(text);
    }

    //getTitle
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


    //Waits
    protected WebElement presenceofElement(By elementlocation) {
       return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementlocation));
    }

    protected WebElement visibleofElement(By elementlocation) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementlocation));
    }

    protected WebElement clickableofElement(By elementlocation) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementlocation));
    }


}

