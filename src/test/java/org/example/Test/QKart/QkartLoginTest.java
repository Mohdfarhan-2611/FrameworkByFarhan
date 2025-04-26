package org.example.Test.QKart;


import org.example.Base.BaseTest;
import org.example.Listener.MyRetryAnalyzer;
import org.example.POJO.LoginQKartUser;
import org.example.Pages.Qkart.LoginQKartPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({org.example.Listener.TestListener.class})
public class QkartLoginTest extends BaseTest {



    @Test(description = "Verify user is able to login with valid credentials",groups = {"sanity","regression"}, dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public void validLogin(LoginQKartUser loginQKartUser)
    {
        String username = new LoginQKartPage().doValidLogin(loginQKartUser.getValidusername(), loginQKartUser.getValidpassword()).getText();
        Assert.assertEquals(username, "Logged in successfully");
    }


    @Test(description = "verify user is not able to login with invalid credentials",groups = {"regression"}, dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public void InvalidLogin(LoginQKartUser loginQKartUser) {
        String error = new LoginQKartPage().doInValidLogin(loginQKartUser.getInvalidusername(), loginQKartUser.getInvalidpassword());
        Assert.assertEquals(error,"Username does not exis");
    }
}
