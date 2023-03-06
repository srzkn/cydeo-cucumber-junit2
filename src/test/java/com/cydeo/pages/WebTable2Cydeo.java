package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable2Cydeo {

    //create constructor
    //initialize the driver instance and this class' instance using PageFactory.initElements
    public WebTable2Cydeo() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (name="username")
    public WebElement usernameInputBox;

    @FindBy (name="password")
    public WebElement passwordInputBox;

    @FindBy (xpath = "//button[.='Login']")
    public WebElement LoginBtn;

    //no parameters. when we call this "login" method, it will directly login using:
    //Username: Test
    //Password: Tester
    public void login(){
        this.usernameInputBox.sendKeys("Test");
        this.passwordInputBox.sendKeys("Tester");
        this.LoginBtn.click();
    }

    //This method will accept 2  parameters and login.:
    //@param username
    //@param password
    public void login(String username, String pw){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(pw);
        LoginBtn.click();
    }

    //This method will log in using credentials from
    // configuration.properties
    public void loginWithConfig(){
        usernameInputBox.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        passwordInputBox.sendKeys(ConfigurationReader.getProperty("webTablePw"));
        LoginBtn.click();
    }
}
