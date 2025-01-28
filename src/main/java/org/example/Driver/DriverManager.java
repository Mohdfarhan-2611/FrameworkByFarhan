package org.example.Driver;

import org.example.Base.commonToAllPages;
import org.example.Utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager  {

    private DriverManager() {

    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }


    public static void init() throws Exception {
        if(getDriver()==null)
        {
            setDriver(new ChromeDriver());
            getDriver().get(PropertiesReader.readKey("url"));
        }
    }


    public static void quit()
    {
        if (getDriver()!=null)
        {
            getDriver().quit();
        }
    }






}
