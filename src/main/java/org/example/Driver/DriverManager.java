package org.example.Driver;

import org.example.Base.commonToAllPages;
import org.example.Utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

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
        String browser = null;
        browser = PropertiesReader.readKey("browser");
        browser = browser.toLowerCase();
        if(Objects.isNull(driver)) {
            switch (browser){

                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--guest");
                    setDriver(new EdgeDriver(edgeOptions));
                    DriverManager.getDriver().get(PropertiesReader.readKey("url"));
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--guest");
                    setDriver(new ChromeDriver(chromeOptions));
                    DriverManager.getDriver().get(PropertiesReader.readKey("url"));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--guest");
                    setDriver(new FirefoxDriver(firefoxOptions));
                    DriverManager.getDriver().get(PropertiesReader.readKey("url"));
                    break;

                default:
                    System.out.println("Browser not found");
            }
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
