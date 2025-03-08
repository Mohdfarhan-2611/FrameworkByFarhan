package org.example.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverManagerTL {
    //constructor

   protected DriverManagerTL(){};

   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {return driver.get();}

    public static void setDriver(WebDriver driverref) {
        driver.set(driverref);
    }

    public static void unload() { driver.remove(); }
}
