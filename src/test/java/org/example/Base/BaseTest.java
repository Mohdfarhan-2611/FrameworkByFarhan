package org.example.Base;

import org.example.Driver.DriverManager;
import org.example.Driver.DriverManagerTL;
import org.testng.annotations.*;

public class BaseTest {
 //public>protected>Default>private
 //constructor- Different package with no subclass cannot create the object
protected BaseTest(){};


 @BeforeMethod
 public void setup() {
  DriverManager.init();  // Ensure WebDriver is initialized before every test
 }



 @AfterMethod
 public void TearDown() {
  DriverManager.quit();
 }








}
