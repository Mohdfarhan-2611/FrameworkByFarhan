package org.example.Test.QKart;

import org.example.Base.BaseTest;
import org.example.POJO.LoginQKartUser;
import org.example.Pages.Qkart.LoginQKartPage;
import org.testng.annotations.Test;

public class QkartLoginTest extends BaseTest {


    @Test(dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public void validLogin(LoginQKartUser loginQKartUser)
    {
        LoginQKartPage loginQKartPage = new LoginQKartPage().doValidLogin(loginQKartUser.getValidusername(), loginQKartUser.getValidpassword());

    }


    @Test(dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public void InvalidLogin(LoginQKartUser loginQKartUser) {
        LoginQKartPage loginQKartPage = new LoginQKartPage().doInValidLogin(loginQKartUser.getInvalidusername(), loginQKartUser.getInvalidpassword());
    }
}
