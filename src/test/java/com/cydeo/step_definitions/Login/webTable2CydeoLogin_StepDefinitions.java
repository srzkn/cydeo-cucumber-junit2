package com.cydeo.step_definitions.Login;

import com.cydeo.pages.WebTable2Cydeo;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class webTable2CydeoLogin_StepDefinitions {

    WebTable2Cydeo webTable2Cydeo=new WebTable2Cydeo();
    @Given("User is on the web tables application login page")
    public void user_is_on_the_web_tables_application_login_page() {
        String url= ConfigurationReader.getProperty("webTableURL");
        Driver.getDriver().get(url);
    }
    @When("user enters {string} username")
    public void user_enters_username(String string) {
    webTable2Cydeo.usernameInputBox.sendKeys(string);
    }
    @When("user enters {string} password")
    public void user_enters_password(String string) {
    webTable2Cydeo.passwordInputBox.sendKeys(string);
    }
    @When("user clicks on Login btn")
    public void user_clicks_on_login_btn() {
    webTable2Cydeo.LoginBtn.click();
    }

    @When("user enters {string} username, {string} password and logins")
    public void user_enters_username_password_and_logins(String username, String pw) {
    webTable2Cydeo.login(username,pw);
    }

    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
       // WE CAN USE 3 CODE LİNES BELOW OR
        // webTable2Cydeo.usernameInputBox.sendKeys(credentials.get("username"));
       // webTable2Cydeo.passwordInputBox.sendKeys(credentials.get("password"));
       // webTable2Cydeo.LoginBtn.click();

        //WE CAN DO THE SAME WİTH THE LINE BELOW:::
        // we are calling our login utility method and pasing value from map
        webTable2Cydeo.login(credentials.get("username"), credentials.get("password"));

    }

    @Then("user lands on a new page that its' URL ends with {string}")
    public void user_lands_on_a_new_page_that_its_url_ends_with(String string) {
        BrowserUtils.VerifyTitleContains(string);
    }
}
