package org.example.Base;

import org.example.Driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class commonToAllTest {





    @BeforeMethod
    public static void init() throws Exception {
       DriverManager.init();
    }


    @AfterMethod
    public static void TearDown()
    {
        DriverManager.quit();
    }

}
