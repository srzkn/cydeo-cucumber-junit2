package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTable2Cydeo;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class webtableOrder_StepDefinitions {
WebTable2Cydeo webTable2Cydeo=new WebTable2Cydeo();
BasePage basePage=new BasePage();
OrderPage orderPage=new OrderPage();

ViewAllOrdersPage viewAllOrdersPage=new ViewAllOrdersPage();
    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {

        //Getting the page webTable2Cydeo
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        //calling our login method to log in webTable2Cydeo page
        webTable2Cydeo.login();
        //clicking to "order" link to go order page.
        basePage.order.click();

    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select product=new Select(orderPage.productDropdown);
        product.selectByValue(string);
    }
    @When("user enters quantity {string}")
    public void user_enters_quantity(String string) {
        orderPage.inputQuantity.clear();
    orderPage.inputQuantity.sendKeys(string);
    }
    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
    orderPage.inputCustomerName.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
    orderPage.inputCity.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
    orderPage.inputState.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
    orderPage.inputZip.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        //this line will loop through the list and decide which radio button to click
        BrowserUtils.clickRadioButton(orderPage.cardType,expectedCardType);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
    orderPage.inputCardNo.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
    orderPage.inputCardExpiryDate.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
    orderPage.processOrderButton.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        Assert.assertEquals(expectedName,viewAllOrdersPage.customerInFirstRow.getText());
    }
}
