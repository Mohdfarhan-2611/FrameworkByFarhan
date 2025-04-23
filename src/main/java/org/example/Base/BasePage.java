package org.example.Base;

import org.example.Driver.DriverManagerTL;
import org.example.Enums.WaitTypes;
import org.example.Factory.ExplicitWaitFactory;
import org.example.Reports.ExtentLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class BasePage {
    //constructor
    protected BasePage(){};


    //ClickElement
    public static void ClickElement(By locator, WaitTypes waitTypes, String elementname){
        WebElement clickElement = ExplicitWaitFactory.performExplicitwait(waitTypes, locator);
        clickElement.click();
        ExtentLogger.pass(elementname+" is clicked");
    }

    //ClickElementByJS
    public static void ClickElementByJS(By locator, WaitTypes waitTypes)
    {
        JavascriptExecutor js = ((JavascriptExecutor) DriverManagerTL.getDriver());
        WebElement element = ExplicitWaitFactory.performExplicitwait(waitTypes, locator);
        js.executeScript("arguments[0].click();",element);


    }

    //SendKeys
    public static void EnterText(By loator, String value, WaitTypes waitTypes, String elementname) {
        WebElement entertext = ExplicitWaitFactory.performExplicitwait(waitTypes, loator);
        entertext.sendKeys(value);
        ExtentLogger.pass(value+" is succesfully entered "+elementname+" is entered");
    }


    //getText
    public static String getText(By locator, WaitTypes waitTypes){
         WebElement element = ExplicitWaitFactory.performExplicitwait(waitTypes, locator);
        return element.getText();
    }


    //isEnabled
    public static boolean isEnabled(By locator, WaitTypes waitTypes)
    {
        WebElement webElement = ExplicitWaitFactory.performExplicitwait(waitTypes, locator);
        return webElement.isEnabled();
    }

    //isPresent
    public boolean isElementPresent(By locator) {

        return !DriverManagerTL.getDriver().findElements(locator).isEmpty();
    }



    //ScrolltoBottom
    public static void ScrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerTL.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    //ScrolltoElement
    public static void ScrollToElement(By locator, WaitTypes waitTypes){
        JavascriptExecutor js = (JavascriptExecutor) DriverManagerTL.getDriver();
        WebElement element = ExplicitWaitFactory.performExplicitwait(waitTypes, locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //MovetoElementbyActionclass
    public static void MoveToElementByAction(By locator, WaitTypes waitTypes) {
        WebElement element = ExplicitWaitFactory.performExplicitwait(waitTypes, locator);
        Actions actions = new Actions(DriverManagerTL.getDriver());
        actions.moveToElement(element);
    }

    //getAllitems on the Page Method
    public static String getAllItems(By locator)
    {
        List<WebElement> elements = DriverManagerTL.getDriver().findElements(locator);
        StringBuilder items = new StringBuilder();

        for(WebElement webElement: elements)
        {
          items.append(webElement.getText()).append(",");
        }

        return items.toString().trim();

    }


    public static void SelectbyVisibleText(By locator, String text, WaitTypes waitTypes)
    {
        WebElement element = ExplicitWaitFactory.performExplicitwait(waitTypes,locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }












    //WaitVisible
    public static void waitVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //waitClickable
    public static void waitClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //waitPresence
    public static void waitPresent(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
