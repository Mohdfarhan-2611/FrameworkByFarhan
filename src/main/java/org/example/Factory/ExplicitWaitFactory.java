package org.example.Factory;

import org.example.Driver.DriverManagerTL;
import org.example.Enums.WaitTypes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

    private static final int EXPLICITWAIT = 30;

    public static int getExplicitwait()
     {
         return EXPLICITWAIT;
     }

     public static WebElement performExplicitwait(WaitTypes waitTypes, By locator)
     {
         WebElement element = null;
         if(waitTypes == WaitTypes.PRESENT){
             element = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(locator));
         }
         else if (waitTypes == WaitTypes.VISIBLE) {
             element = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(locator));
         }
         else if (waitTypes == WaitTypes.CLICKABLE) {
             element = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(getExplicitwait())).until(ExpectedConditions.elementToBeClickable(locator));
         }
         else{
             System.out.println("Element is not found");
         }
         return element;
     }





}
