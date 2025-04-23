package org.example.Pages.Qkart;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Enums.WaitTypes;
import org.example.Reports.ExtentLogger;
import org.example.Reports.ExtentReport;
import org.example.Reports.ExtentReportManager;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.By;

public class LoginQKartPage extends BasePage {


    //Elements = By class
    private static final By LOGIN_LINK_HOMEPAGE = By.xpath("//button[@type='button' and contains(text(),'Login')]");
    private static final By REGISTER_LINK_HOMEPAGE = By.xpath("");
    private static final By USERNAME_TEXT_FIELD =By.xpath("//input[@id='username']");
    private static final By PASSWORD_TEXT_FIELD =By.xpath("//input[@id='password']");
    private static final By LOGINTOQKART_BUTTON = By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]");
    private static final By LOGOUT_LINK = By.xpath("//button[@type='primary' and contains(text(),'Logout')]");
    private static final By ERROR_MESSAGE=By.xpath("//div[@id='notistack-snackbar']");

    //Actions1:
    public HomeQKartPage doValidLogin(String email, String pass)
    {
        ClickElement(LOGIN_LINK_HOMEPAGE, WaitTypes.PRESENT, "Loginlink");
        EnterText(USERNAME_TEXT_FIELD, email, WaitTypes.CLICKABLE, "Username");
        EnterText(PASSWORD_TEXT_FIELD, pass, WaitTypes.CLICKABLE, "Password");
        ClickElement(LOGINTOQKART_BUTTON, WaitTypes.CLICKABLE, "LoginButton");
        return new HomeQKartPage();

    }

    //Action2:
    public String doInValidLogin(String email, String pass)
    {
        ClickElement(LOGIN_LINK_HOMEPAGE, WaitTypes.PRESENT,"Loginlink");
        EnterText(USERNAME_TEXT_FIELD, email, WaitTypes.CLICKABLE, "Username");
        EnterText(PASSWORD_TEXT_FIELD, pass, WaitTypes.CLICKABLE,"Password");
        ClickElement(LOGINTOQKART_BUTTON, WaitTypes.CLICKABLE, "LoginButton");
        return getText(ERROR_MESSAGE, WaitTypes.VISIBLE);
    }



}

//Login Page

//Elements
//Locator are stored in selenium "By"
//Actions

//Encapsulaing them in class