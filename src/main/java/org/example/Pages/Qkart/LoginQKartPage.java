package org.example.Pages.Qkart;

import org.example.Base.BasePage;
import org.example.Enums.WaitTypes;
import org.openqa.selenium.By;

public class LoginQKartPage extends BasePage {

    private static final By LOGIN_LINK_HOMEPAGE = By.xpath("//button[@type='button' and contains(text(),'Login')]");
    private static final By REGISTER_LINK_HOMEPAGE = By.xpath("");
    private static final By USERNAME_TEXT_FIELD =By.xpath("//input[@id='username']");
    private static final By PASSWORD_TEXT_FIELD =By.xpath("//input[@id='password']");
    private static final By LOGINTOQKART_BUTTON = By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]");
    private static final By LOGOUT_LINK = By.xpath("//button[@type='primary' and contains(text(),'Logout')]");
    private static final By ERROR_MESSAGE=By.xpath("//div[@id='notistack-snackbar']");


    public HomeQKartPage doValidLogin(String email, String pass)
    {
        ClickElement(LOGIN_LINK_HOMEPAGE, WaitTypes.PRESENT);
        EnterText(USERNAME_TEXT_FIELD, email, WaitTypes.CLICKABLE);
        EnterText(PASSWORD_TEXT_FIELD, pass, WaitTypes.CLICKABLE);
        ClickElement(LOGINTOQKART_BUTTON, WaitTypes.CLICKABLE);
        return new HomeQKartPage();

    }


    public String doInValidLogin(String email, String pass)
    {
        ClickElement(LOGIN_LINK_HOMEPAGE, WaitTypes.PRESENT);
        EnterText(USERNAME_TEXT_FIELD, email, WaitTypes.CLICKABLE);
        EnterText(PASSWORD_TEXT_FIELD, pass, WaitTypes.CLICKABLE);
        ClickElement(LOGINTOQKART_BUTTON, WaitTypes.CLICKABLE);
        return getText(ERROR_MESSAGE, WaitTypes.VISIBLE);
    }



}
