package org.example.Pages.Avibra;

import org.example.Base.commonToAllPages;
import org.openqa.selenium.By;

public class AvibraHomePage extends commonToAllPages {



    //Locators
    private By profile_Icon = By.xpath("//div[@class='profile profile-header-style col']//button");
    private By logout_Btn = By.xpath("//div[@class='popover-body']//a");




    //Actions
    public AvibraHomePage clickProfileIcon()
    {
        presenceofElement(profile_Icon);
        ClickElement(profile_Icon);
        return this;
    }


    public AvibraLoginPage clickLogoutbtn()
    {
        visibleofElement(logout_Btn);
        ClickElement(logout_Btn);
        return new AvibraLoginPage();
    }

    public String getTitle()
    {
        return getPageTitle();
    }




}
