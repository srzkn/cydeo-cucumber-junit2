package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SPRINT3_LoginPage {

    public SPRINT3_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (name = "_username")
    public WebElement inputUsername;

    @FindBy (name = "_password")
    public WebElement inputPassword;

    @FindBy (id = "_submit")
    public WebElement LoginButton;

    @FindBy (xpath = "//a[.='Forgot your password?']")
    public WebElement ForgotYourPasswordLink;

    @FindBy (xpath = "//h1[.='Quick Launchpad']")
    public WebElement QuickLaunchpadHeader;

    @FindBy (xpath = "//h1[contains(text(),'Dashboard')]")
    public WebElement DashboardHeader;

    @FindBy (xpath = "//div[.='Invalid user name or password.']")
    public WebElement invalidUsernameOrPasswordMessage;

    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public WebElement rememberMeLink;

    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeIcon;

    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    public WebElement dropdown;




}
