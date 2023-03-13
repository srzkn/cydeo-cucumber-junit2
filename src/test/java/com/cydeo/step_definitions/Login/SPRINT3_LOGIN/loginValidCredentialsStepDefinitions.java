package com.cydeo.step_definitions.Login.SPRINT3_LOGIN;

import com.cydeo.pages.SPRINT3_LoginPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import javax.swing.*;

public class loginValidCredentialsStepDefinitions {

    SPRINT3_LoginPage sprint3LoginPage=new SPRINT3_LoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get("http://qa.xfleetsolutions.com/");
    }
    @When("The user clicks on the Forgot your password? link")
    public void the_user_clicks_on_the_forgot_your_password_link() {
        sprint3LoginPage.ForgotYourPasswordLink.click();
    }
    @Then("the user is on the Forgot Password page")
    public void the_user_is_on_the_forgot_password_page() {
        String expectedInUrl="//qa.xfleetsolutions.com/user/reset-request";
        System.out.println("expectedUrl = " + expectedInUrl);
        System.out.println("Driver.getDriver().getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInUrl));
    }

    @When("The user enters {string}")
    public void the_user_enters(String password) {
        sprint3LoginPage.inputPassword.sendKeys(password);
    }
    @Then("the user should see the password in bullet signs")
    public void the_user_should_see_the_password_in_bullet_signs() {
        String pw="password";
        System.out.println("sprint3LoginPage = " + sprint3LoginPage.inputPassword.getAttribute("type"));
        Assert.assertEquals(sprint3LoginPage.inputPassword.getAttribute("type"),pw);
    }

    @Then("User can see Remember Me link exists and is clickable on the login page")
    public void user_can_see_remember_me_link_exists_and_is_clickable_on_the_login_page() {
        Assert.assertTrue(sprint3LoginPage.rememberMeLink.isDisplayed());
        Assert.assertTrue(sprint3LoginPage.rememberMeIcon.isDisplayed());
    }

    @When("The user logs in as a driver and hits enter key")
    public void the_user_logs_in_as_a_driver_and_hits_enter_key() {
        sprint3LoginPage.inputUsername.sendKeys("user1");
        sprint3LoginPage.inputPassword.sendKeys("UserUser123"+Keys.ENTER);
    }
    @Then("the user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() {
        Assert.assertTrue(sprint3LoginPage.QuickLaunchpadHeader.isDisplayed());
    }

    @When("The user logs in as a driver")
    public void the_user_logs_in_as_a_driver() {
        sprint3LoginPage.inputUsername.sendKeys("user1");
        sprint3LoginPage.inputPassword.sendKeys("UserUser123");
        sprint3LoginPage.LoginButton.click();
    }

    @When("the user logs in as a Sales Manager")
    public void the_user_logs_in_as_a_sales_manager() {
        sprint3LoginPage.inputUsername.sendKeys("salesmanager101");
        sprint3LoginPage.inputPassword.sendKeys("UserUser123");
        sprint3LoginPage.LoginButton.click();
    }

    @When("the user logs in as a Store Manager")
    public void the_user_logs_in_as_a_store_manager() {
        sprint3LoginPage.inputUsername.sendKeys("storemanager51");
        sprint3LoginPage.inputPassword.sendKeys("UserUser123");
        sprint3LoginPage.LoginButton.click();
    }
    @Then("the user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() {
        Assert.assertTrue(sprint3LoginPage.DashboardHeader.isDisplayed());
    }
    @Then("the user can not login and {string} error message is displayed.")
    public void the_user_can_not_login_and_error_message_is_displayed(String message) {
        boolean flag = false;
        if (sprint3LoginPage.inputUsername.getText().equals("")){
            if(sprint3LoginPage.inputUsername.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        if(sprint3LoginPage.inputPassword.getText().equals("")){
            if(sprint3LoginPage.inputPassword.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }
    @Then("users can see their own {string} in the profile menu")
    public void users_can_see_their_own_in_the_profile_menu(String expectedName) {
        System.out.println("expectedName = " + expectedName);
        String actualName=sprint3LoginPage.dropdown.getText();
        System.out.println("actualName = " + actualName);
        Assert.assertEquals(expectedName,actualName);
    }

    @When("The user trys to login with {string} and {string}")
    public void the_user_trys_to_login_with_and(String username, String password) {
        sprint3LoginPage.inputUsername.sendKeys(username);
        sprint3LoginPage.inputPassword.sendKeys(password);
        sprint3LoginPage.LoginButton.click();
    }

    @Then("the user can not login and \\(Invalid username or password) error message is displayed.")
    public void the_user_can_not_login_and_invalid_username_or_password_error_message_is_displayed() {
        sprint3LoginPage.invalidUsernameOrPasswordMessage.isDisplayed();
    }

}
