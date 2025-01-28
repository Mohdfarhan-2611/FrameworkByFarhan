package org.example.Test.Avibra;

import org.assertj.core.api.Assertions;
import org.example.Base.commonToAllTest;
import org.example.Driver.DriverManager;
import org.example.Pages.Avibra.AvibraHomePage;
import org.example.Pages.Avibra.AvibraLoginPage;
import org.example.Utils.PropertiesReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AvibraLoginLogoutTest extends commonToAllTest {


    @Test(dataProvider = "AVIBRALOGINLOGOUT")
    public void AvibraLoginLogout(String username, String password) throws InterruptedException {

       String title;
       try {
            title = new AvibraLoginPage()
                   .enterUsername(username).enterPassword(password).clickLogin()
                   .clickProfileIcon().clickLogoutbtn()
                    .getTitle();
       }
       catch (Exception e)
       {
        throw new RuntimeException(e);
       }

        Assertions.assertThat(title).isNotBlank().isNotNull().isNotEmpty()
                .isEqualTo("Avibra - Live Well & Earn Insurance");
    }


    @DataProvider(name = "AVIBRALOGINLOGOUT")
    public static Object[][] getData() throws Exception {
        // Flattening the 2D array from the Excel data
        Object[][] excelData = PropertiesReader.readTestDataFromExcel();
        System.out.println("DataProvider data: " + Arrays.deepToString(excelData));
        return excelData;
    }

}
