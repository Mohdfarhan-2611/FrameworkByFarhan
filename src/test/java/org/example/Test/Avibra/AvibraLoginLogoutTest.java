package org.example.Test.Avibra;

import org.example.Base.commonToAllTest;
import org.example.Pages.Avibra.AvibraHomePage;
import org.example.Pages.Avibra.AvibraLoginPage;
import org.testng.annotations.Test;

public class AvibraLoginLogoutTest extends commonToAllTest {


    @Test
    public void AvibraLoginLogout() throws InterruptedException {
        AvibraLoginPage avibraLoginPage = new AvibraLoginPage();
               avibraLoginPage.enterUsername("kumarsanjay2001us@gmail.com");
               avibraLoginPage.enterPassword("c0dpiI#8");
               avibraLoginPage.clickLogin();

        Thread.sleep(30000);

        AvibraHomePage avibraHomePage = new AvibraHomePage();
        avibraHomePage.clickProfileIcon().clickLogoutbtn();

    }


}
