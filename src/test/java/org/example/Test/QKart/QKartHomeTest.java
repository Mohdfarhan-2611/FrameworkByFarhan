package org.example.Test.QKart;

import org.example.Base.BaseTest;
import org.example.POJO.LoginQKartUser;
import org.example.Pages.Qkart.LoginQKartPage;
import org.example.Pages.Qkart.HomeQKartPage;
import org.testng.annotations.Test;

public class QKartHomeTest extends BaseTest {



    @Test(description = "Verify the user is able to click About us", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public static void clickPrivacyPolicy(LoginQKartUser user) {
        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).clickPrivacyPolicy();
    }


    @Test(description = "Verify the user is able to click About us", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public static void clickAboutUS(LoginQKartUser user){

        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).clickAboutUs();

    }

    @Test(description = "Verify the user is able to click Term of service", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public static void clickTermofService(LoginQKartUser user){
        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).ClickTermOdService();
    }


    @Test(description = "Verify the user is able to get all list item", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public static void getAllitemonthePage(LoginQKartUser user){
        String itemOnThePage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).ListofItems();
        System.out.println(itemOnThePage);
    }

    @Test(description="verify the user is able to place order", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public static void placeOrder(LoginQKartUser user) throws InterruptedException {
       HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).placeOrder();
    }



    @Test(description="verify the user is able to select the size of product from dropdown", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE")
    public static void ChangeProductsize(LoginQKartUser user) throws InterruptedException {
        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).selectProductSizeAndIncreaseCountandPlaceOrder();
    }


}
