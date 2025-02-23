package org.example.Pages.Qkart;

import org.example.Base.BasePage;
import org.example.POJO.LoginQKartUser;
import org.openqa.selenium.By;

public class LoginQKartPage extends BasePage {

    private static final By LOGIN_LINK_HOMEPAGE = By.xpath("//button[@type='button' and contains(text(),'Login')]");
    private static final By REGISTER_LINK_HOMEPAGE = By.xpath("");
    private static final By USERNAME_TEXT_FIELD =By.xpath("//input[@id='username']");
    private static final By PASSWORD_TEXT_FIELD =By.xpath("//input[@id='password']");
    private static final By LOGINTOQKART_BUTTON = By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]");
    private static final By LOGOUT_LINK = By.xpath("//button[@type='primary' and contains(text(),'Logout')]");



    public LoginQKartPage doValidLogin(String email, String pass)
    {
        waitPresent(LOGIN_LINK_HOMEPAGE);
        ClickElement(LOGIN_LINK_HOMEPAGE);
        waitClickable(USERNAME_TEXT_FIELD);
        EnterText(USERNAME_TEXT_FIELD, email);
        waitClickable(PASSWORD_TEXT_FIELD);
        EnterText(PASSWORD_TEXT_FIELD, pass);
        waitClickable(LOGINTOQKART_BUTTON);
        ClickElement(LOGINTOQKART_BUTTON);
        waitVisible(LOGOUT_LINK);
        ClickElement(LOGOUT_LINK);
        return this;
    }


    public LoginQKartPage doInValidLogin(String email, String pass)
    {
        waitPresent(LOGIN_LINK_HOMEPAGE);
        ClickElement(LOGIN_LINK_HOMEPAGE);
        waitClickable(USERNAME_TEXT_FIELD);
        EnterText(USERNAME_TEXT_FIELD, email);
        waitClickable(PASSWORD_TEXT_FIELD);
        EnterText(PASSWORD_TEXT_FIELD, pass);
        waitClickable(LOGINTOQKART_BUTTON);
        ClickElement(LOGINTOQKART_BUTTON);
        return this;
    }





}
