package org.example.Pages.Avibra;

import org.example.Base.commonToAllPages;
import org.example.Driver.DriverManager;
import org.openqa.selenium.By;

public class AvibraLoginPage extends commonToAllPages {

    //Locators
    private final By textbox_username= By.xpath("//input[@type='email']");
    private final By textbox_password= By.xpath("//input[@type='password']");
    private final By login_btn= By.xpath("//button[@type='submit']");



    //Actions
    public AvibraLoginPage enterUsername(String user)
    {
        visibleofElement(textbox_username);
        EnterText(textbox_username, user);
        return this;

    }

    public AvibraLoginPage enterPassword(String pass)
    {
        visibleofElement(textbox_password);
        EnterText(textbox_password, pass);
        return this;

    }

    public AvibraHomePage clickLogin()
    {
        visibleofElement(login_btn);
        ClickElement(login_btn);
        return new AvibraHomePage();
    }

    public String getTitle()
    {
        return getPageTitle();
    }


}
