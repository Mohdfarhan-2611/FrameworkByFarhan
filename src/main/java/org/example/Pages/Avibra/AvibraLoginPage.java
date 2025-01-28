package org.example.Pages.Avibra;

import org.example.Driver.DriverManager;
import org.openqa.selenium.By;

public class AvibraLoginPage {

    //Locators
    private final By textbox_username= By.xpath("//input[@type='email']");
    private final By textbox_password= By.xpath("//input[@type='password']");
    private final By login_btn= By.xpath("//button[@type='submit']");



    //Actions
    public AvibraLoginPage enterUsername(String user)
    {
        DriverManager.getDriver().findElement(textbox_username).sendKeys(user);
        return this;
    }

    public AvibraLoginPage enterPassword(String pass)
    {
        DriverManager.getDriver().findElement(textbox_password).sendKeys(pass);
        return this;
    }

    public AvibraHomePage clickLogin()
    {
       DriverManager.getDriver().findElement(login_btn).click();
       return new AvibraHomePage();
    }


}
