package org.example.Pages.Avibra;

import org.example.Driver.DriverManager;
import org.openqa.selenium.By;

public class AvibraHomePage {



    //Locators
    private By profile_icon = By.xpath("//div[@class='profile profile-header-style col']//button");
    private By logout_btn = By.xpath("//div[@class='popover-body']//a");




    //Actions
    public AvibraHomePage clickProfileIcon()
    {
        DriverManager.getDriver().findElement(profile_icon).click();
        return this;
    }


    public AvibraLoginPage clickLogoutbtn()
    {
        DriverManager.getDriver().findElement(logout_btn).click();
        return new AvibraLoginPage();
    }




}
