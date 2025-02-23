package org.example.Base;

import org.example.Driver.DriverManager;
import org.example.Driver.DriverManagerTL;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
 //public>protected>Default>private
 //constructor- Different package with no subclass cannot create the object
protected BaseTest(){};


@BeforeTest
public void setup(){
 DriverManager.init();
}


@AfterTest
public void TearDown(){
 DriverManager.quit();
}








}
