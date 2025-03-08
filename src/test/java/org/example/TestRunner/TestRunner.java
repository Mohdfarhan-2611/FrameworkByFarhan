package org.example.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles/LoginPage.feature", // Path to your feature files
        glue = {"org.example.Test.QKart.Stepdefs"}, // Package where step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}, // Reports
        monochrome = true // Better console output readability
)
public class TestRunner extends AbstractTestNGCucumberTests {


}
