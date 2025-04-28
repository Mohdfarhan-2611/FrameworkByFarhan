package org.example.Listener;

import org.apache.logging.log4j.Logger;
import org.example.Base.BasePage;
import org.example.Base.BaseTest;
import org.example.Reports.ExtentLogger;
import org.example.Reports.ExtentReport;
import org.example.Utils.LoggerUtility;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Arrays;


public class TestListener implements ITestListener, ISuiteListener {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReport.createTest(result.getMethod().getMethodName());
    }


    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "PASSED");
        ExtentLogger.pass(result.getMethod().getMethodName() + " " + "PASSED");
    }


    public void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " " + "FAILED");
        logger.info(result.getThrowable().getMessage());
        ExtentLogger.fail(result.getMethod().getMethodName() + " " + "Failed");
        ExtentLogger.fail(result.getThrowable().getMessage());
        Object testClass = result.getInstance();

        try {
            BasePage basePage = ((BaseTest) testClass).getInstance();
            String screenshotPath = basePage.takeScreenshot(result.getMethod().getMethodName());
            ExtentLogger.addScreenshotpath(screenshotPath);
        } catch (Exception e) {
            ExtentLogger.fail("Screenshot capture failed: " + e.getMessage());
        }


    }


    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
        ExtentLogger.skip(result.getMethod().getMethodName() + " " + "Skipped");
        ExtentLogger.skip(result.getThrowable().getMessage());
    }


    public void onStart(ITestContext context) {
        logger.info("Test suite started");
        ExtentReport.setup();

    }


    public void onFinish(ITestContext context) {
        logger.info("Test suited completed");
        try {
            ExtentReport.tearDown();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
