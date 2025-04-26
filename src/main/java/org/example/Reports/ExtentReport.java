package org.example.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.example.Driver.DriverManagerTL;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private static final String REPORT_PATH = System.getProperty("user.dir") + "/report.html";
    static ExtentSparkReporter sparkReporter;
    static ExtentReports extentReport;


    public static void setup() {
        if (Objects.isNull(extentReport)) {
            sparkReporter = new ExtentSparkReporter(REPORT_PATH);
            extentReport = new ExtentReports();
            extentReport.attachReporter(sparkReporter);
        }
    }

    public static void tearDown() throws IOException {
        if (Objects.nonNull(extentReport)) {
            extentReport.flush();
            Desktop.getDesktop().browse(new File(REPORT_PATH).toURI());
        }
    }


    public static void createTest(String testcaseName){
        ExtentReportManager.setExtentTest(extentReport.createTest(testcaseName));

    }




}
