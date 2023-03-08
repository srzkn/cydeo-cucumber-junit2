package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class WikipediaStepDefinitions {

    WikipediaSearchPage wikipediaSearchPage=new WikipediaSearchPage();

    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }
    @When("user types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikipediaSearchPage.searchBox.sendKeys(string);
    }

    @Then("user sees {string} in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
        String expectedTitle=string+" - Wikipedia";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @Then("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearchPage.searchButton.click();
    }



    @Then("user sees {string} in the main header")
    public void user_sees_in_the_main_header(String string) {
        String expectedTitle=string;
        String actualTitle=wikipediaSearchPage.mainHeader.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("user sees Steve Jobs is in the image header")
    public void user_sees_steve_jobs_is_in_the_image_header() {

    }

    @Then("user sees {string} in the image header")
    public void user_sees_in_the_image_header(String string) {
        String expectedInTitle="Jobs";
        String actualTitle=wikipediaSearchPage.imageHeader.getText();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
}
