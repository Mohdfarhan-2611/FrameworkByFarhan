package org.example.Test.QKart;

import org.example.Base.BaseTest;
import org.example.POJO.LoginQKartUser;
import org.example.Pages.Qkart.LoginQKartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QkartLoginTest extends BaseTest {


    @Test(dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public void validLogin(LoginQKartUser loginQKartUser)
    {
        String username = new LoginQKartPage().doValidLogin(loginQKartUser.getValidusername(), loginQKartUser.getValidpassword()).getText();
        Assert.assertEquals(username, "Logged in successfully");

    }


    @Test(dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public void InvalidLogin(LoginQKartUser loginQKartUser) {
        String error = new LoginQKartPage().doInValidLogin(loginQKartUser.getInvalidusername(), loginQKartUser.getInvalidpassword());
        Assert.assertEquals(error,"Username does not exist");
    }
}
