package org.example.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverManagerTL {
    //constructor   //singletonDesignPattern: PrivateConstructor
   //indrectly : Can a constructor be a private?
    //1 we can not the object of the class
    //we can create the singletonDesignPattern

   private DriverManagerTL(){};

   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverref) {

        driver.set(driverref);
    }

    public static void unload() { driver.remove(); }
}



//Encapsulation
//private static Instance
//public getter
//public setter







