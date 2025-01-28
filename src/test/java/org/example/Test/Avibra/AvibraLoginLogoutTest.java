package org.example.Test.Avibra;

import org.example.Base.commonToAllTest;
import org.example.Driver.DriverManager;
import org.example.Pages.Avibra.AvibraHomePage;
import org.example.Pages.Avibra.AvibraLoginPage;
import org.testng.annotations.Test;

public class AvibraLoginLogoutTest extends commonToAllTest {


    @Test
    public void AvibraLoginLogout() throws InterruptedException {

       String title = null;
       try {
            title = new AvibraLoginPage()
                   .enterUsername("kumarsanjay2001us@gmail.com").enterPassword("c0dpiI#8").clickLogin()
                   .clickProfileIcon().clickLogoutbtn().getTitle();
       }
       catch (Exception e)
       {
        throw new RuntimeException(e);
       }

        System.out.println(title);


    }


}
