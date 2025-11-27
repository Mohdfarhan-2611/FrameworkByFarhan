package org.example.Reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {

    private ExtentReportManager(){}

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTest.get();}

    static void setExtentTest(ExtentTest Test) {
        extentTest.set(Test);
    }

    static void unload() {
        extentTest.remove();
    }

    }


