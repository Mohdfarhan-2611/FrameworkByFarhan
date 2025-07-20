package org.example.Base;

import org.apache.logging.log4j.Logger;
import org.example.Driver.DriverManager;
import org.example.Driver.DriverManagerTL;
import org.example.Pages.Qkart.HomeQKartPage;
import org.example.Pages.Qkart.LoginQKartPage;
import org.example.Utils.LambdaTestUtility;
import org.example.Utils.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
 //public>protected>Default>private
 //constructor- Different package with no subclass cannot create the object
 protected LoginQKartPage loginQKartPage;
 protected HomeQKartPage homeQKartPage;

 Logger logger = LoggerUtility.getLogger(this.getClass());
 private boolean isLambdaTest = false;
 private boolean isHeadless = true;


protected BaseTest(){};


 @BeforeMethod
 public void setup(ITestResult result) {
  WebDriver lambdaDriver;
  if(isLambdaTest){
     lambdaDriver = LambdaTestUtility.initializeLambdaTestSession("chrome", result.getMethod().getMethodName());
     DriverManagerTL.setDriver(lambdaDriver);
     logger.info("Running on LambdaTest: "+result.getMethod().getMethodName());
  }
  else {
     logger.info("Running test locally on Chrome browser");
     DriverManager.init();  // Ensure WebDriver is initialized before every test
     loginQKartPage = new LoginQKartPage();
    }
 }

 @AfterMethod
 public void TearDown() {
  if(isLambdaTest){
   LambdaTestUtility.quitSession();
  }else {
   DriverManager.quit();
  }
 }


 public BasePage getInstance(){
   return loginQKartPage;
  }
}
