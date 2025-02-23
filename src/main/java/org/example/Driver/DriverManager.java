package org.example.Driver;

import org.example.Utils.PropertiesUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;
import java.util.Properties;

public class DriverManager {

    //contructor
    protected DriverManager() {
    }

    //launch browser and geturl
    public static void init() {
        String browser = null;
        browser = PropertiesUtils.readkey("browser");
        boolean isheadless = Boolean.parseBoolean(PropertiesUtils.readkey("isheadless"));
        browser = browser.toLowerCase();
        if (Objects.isNull(DriverManagerTL.getDriver())) {
            switch (browser) {
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--guest");
                    if (isheadless) {
                        edgeOptions.addArguments("--headless=new");
                        edgeOptions.addArguments("--window-size=1920,1080");
                        edgeOptions.addArguments("--disable-gpu");
                    } else {
                        edgeOptions.addArguments("--start-maximized");
                    }
                    DriverManagerTL.setDriver(new EdgeDriver(edgeOptions));
                    DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--guest");
                    if (isheadless) {
                        chromeOptions.addArguments("--headless=new");
                        chromeOptions.addArguments("--window-size=1920,1080");
                        chromeOptions.addArguments("--disable-gpu");
                    } else {
                        chromeOptions.addArguments("--start-maximized");
                    }
                    DriverManagerTL.setDriver(new ChromeDriver(chromeOptions));
                    DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--guest");
                    if (isheadless) {
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--window-size=1920,1080");
                        firefoxOptions.addArguments("--disable-gpu");
                    } else {
                        firefoxOptions.addArguments("--start-maximized");
                    }
                    DriverManagerTL.setDriver(new FirefoxDriver(firefoxOptions));
                    DriverManagerTL.getDriver().get(PropertiesUtils.readkey("url"));
                    break;

                default:
                    System.out.println("Browser not found");
            }
        }
    }


    public static void quit() {
        if (Objects.nonNull(DriverManagerTL.getDriver())) {
            DriverManagerTL.getDriver().quit();
            DriverManagerTL.unload();
        }
    }
}
