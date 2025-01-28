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
    public void enterUsername(String user)
    {
        EnterText(textbox_username, user);

    }

    public void enterPassword(String pass)
    {
        EnterText(textbox_password, pass);

    }

    public void clickLogin()
    {
       ClickElement(login_btn);

    }


}
