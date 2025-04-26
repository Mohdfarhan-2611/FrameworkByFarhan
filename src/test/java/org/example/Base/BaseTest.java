package org.example.Base;

import org.example.Driver.DriverManager;
import org.example.Pages.Qkart.HomeQKartPage;
import org.example.Pages.Qkart.LoginQKartPage;
import org.testng.annotations.*;

public class BaseTest {
 //public>protected>Default>private
 //constructor- Different package with no subclass cannot create the object
 protected LoginQKartPage loginQKartPage;
 protected HomeQKartPage homeQKartPage;


protected BaseTest(){};


 @BeforeMethod
 public void setup() {
  DriverManager.init();  // Ensure WebDriver is initialized before every test
  loginQKartPage = new LoginQKartPage();
 }



 @AfterMethod
 public void TearDown() {
  DriverManager.quit();
 }


 public BasePage getInstance(){
   return loginQKartPage;
 }


}
