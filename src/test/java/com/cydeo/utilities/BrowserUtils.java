package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
This method will accept int (in seconds) and execute Thread.sleep for given duration
 */
    public static void sleep (int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){
        }

    }

    /*
    This method accepts 3 arguments:
    Arg1:  WebDriver
    Arg2:  expectedInUrl : to verify if the url contains given String.
           - if condition matches, will break loop.
    Arg3: expectedInTitle to be compared against actualTitle
    */
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        Set<String> allWindowsHandles=Driver.getDriver().getWindowHandles();

        for (String eachWindow : allWindowsHandles) {
            Driver.getDriver().switchTo().window(eachWindow);
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        // 5. Assert:Title contains “Etsy”
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }

    /**
    this method accepts a String "expected Title" and Asserts if it is true
     */
    public static void VerifyTitle(String expectedTitle){
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public static void VerifyTitleContains(String expectedInTitle){
        String actualTitle2=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle2.contains(expectedInTitle));
    }

    public static void waitForInvisibilityOf(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }
/** This method will accept a dropdown as a WebElement
*  and return all the options' text in a list of String
* @param dropdownElement
* @return List<String> actualOptionsAsString
*/
    public static List<String>dropdownOptionsAsString(WebElement dropdownElement){
        Select select=new Select(dropdownElement);

        //List of all ACTUAL month <options> as a web element
        List<WebElement>actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month <options> as a String
        List<String> actualOptionsAsString=new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**
    this method will accept a group of radio buttons as a List of WebElement.
     It will loop through the List, and click to the radio button with provided attributeValue
     @param radioButtons
     @param attributeValue
     */
    public static void clickRadioButton(List<WebElement>radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }

    }




}
