package org.example.Test.QKart.Stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.Base.BaseTest;
import org.example.Pages.Qkart.HomeQKartPage;
import org.example.Pages.Qkart.LoginQKartPage;
import org.testng.Assert;

public class LoginPageStepdefs  extends BaseTest {
    private LoginQKartPage loginPage;
    private HomeQKartPage homePage;
    private String error;

    @Given("User is on QKart login page")
    public void user_is_on_qkart_login_page() {
        loginPage = new LoginQKartPage();
    }

    @When("User logs in with valid credentials {string} and {string}")
    public void user_logs_in_with_valid_credentials_and(String email, String pass) {

        homePage = loginPage.doValidLogin(email, pass);

    }
    @When("User logs in with invalid credentials {string} and {string}")
    public void user_logs_in_with_invalid_credentials_and(String email, String pass) {

         error = loginPage.doInValidLogin(email, pass);
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        String username = homePage.getText();
        Assert.assertEquals(username,"mhdfarhan2611@gmail.com");
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        Assert.assertEquals(error,"Username does not exist");
    }
}
