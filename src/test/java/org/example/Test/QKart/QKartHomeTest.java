package org.example.Test.QKart;

import org.apache.logging.log4j.Logger;
import org.example.Base.BaseTest;
import org.example.Listener.MyRetryAnalyzer;
import org.example.POJO.LoginQKartUser;
import org.example.Pages.Qkart.LoginQKartPage;
import org.example.Pages.Qkart.HomeQKartPage;
import org.example.Utils.LoggerUtility;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({org.example.Listener.TestListener.class})
public class QKartHomeTest extends BaseTest {



    @Test(description = "Verify the user is able to click About us", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public static void clickPrivacyPolicy(LoginQKartUser user) {
        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).clickPrivacyPolicy();
    }


    @Test(description = "Verify the user is able to click About us", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public static void clickAboutUS(LoginQKartUser user){

        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).clickAboutUs();

    }

    @Test(description = "Verify the user is able to click Term of service", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public static void clickTermofService(LoginQKartUser user){
        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).ClickTermOdService();
    }


    @Test(description = "Verify the user is able to get all list item", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public static void getAllitemonthePage(LoginQKartUser user){
        String itemOnThePage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).ListofItems();
        System.out.println(itemOnThePage);
    }

    @Test(description="verify the user is able to place order", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public static void placeOrder(LoginQKartUser user) throws InterruptedException {
       HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).placeOrder();
    }



    @Test(description="verify the user is able to select the size of product from dropdown", dataProviderClass=org.example.DataProvider.DataProviderGetData.class, dataProvider = "LOGINDATAFROMCSVFILE", retryAnalyzer = MyRetryAnalyzer.class)
    public static void ChangeProductsize(LoginQKartUser user) throws InterruptedException {
        HomeQKartPage homeQKartPage = new LoginQKartPage().doValidLogin(user.getValidusername(), user.getValidpassword()).selectProductSizeAndIncreaseCountandPlaceOrder();
    }


}
