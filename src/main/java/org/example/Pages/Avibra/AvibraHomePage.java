package org.example.Pages.Avibra;

import org.example.Base.commonToAllPages;
import org.example.Driver.DriverManager;
import org.openqa.selenium.By;

public class AvibraHomePage extends commonToAllPages {



    //Locators
    private By profile_icon = By.xpath("//div[@class='profile profile-header-style col']//button");
    private By logout_btn = By.xpath("//div[@class='popover-body']//a");




    //Actions
    public void clickProfileIcon()
    {
        ClickElement(profile_icon);
    }


    public void clickLogoutbtn()
    {
        ClickElement(logout_btn);
    }




}
