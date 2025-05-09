package org.example.Reports;

public final class ExtentLogger {

    private ExtentLogger(){};


    public static void pass(String message){
      ExtentReportManager.getExtentTest().pass(message);
    }


    public static void fail(String message){
      ExtentReportManager.getExtentTest().fail(message);
    }


    public static void skip(String message){
     ExtentReportManager.getExtentTest().skip(message);
    }

    public static void addScreenshotpath(String path){
        ExtentReportManager.getExtentTest().addScreenCaptureFromPath(path);
    }


}
