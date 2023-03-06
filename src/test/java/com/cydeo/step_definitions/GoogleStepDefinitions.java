package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
    GoogleSearchPage googleSearchPage =new GoogleSearchPage();

    @When("user is on Google search page")
    public void user_is_on_goggle_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }

    @When("user types apple and clicks enter")
    public void user_types_apple_and_clicks_enter() {

        googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String string) {
  googleSearchPage.searchBox.sendKeys(string + Keys.ENTER);
    }

    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String expectedTitle=string+" - Google'da Ara";
        String actualTitle=Driver.getDriver().getTitle();

        //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals("Title is not as expected",expectedTitle,actualTitle);
    }

    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
       Assert.assertTrue(Driver.getDriver().getTitle().contains("apple"));
    }

    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
    String expectedTitle="Google";
    String actualTitle=Driver.getDriver().getTitle();

    //Junit assertion accepts first arg as expected, second arg as actual
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
