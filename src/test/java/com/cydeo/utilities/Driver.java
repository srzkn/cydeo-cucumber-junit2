package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {


    /*
    Creating a private constructor. so we are closing access to the object of this class from outside the class
     */
    private Driver(){
    }
    static String browserType;

    /* we make Webdriver private, because we want to close access from outside the class.
 We make it static because we will use it in a static method.*/
    //private static WebDriver getDriver;

    private  static InheritableThreadLocal<WebDriver>driverPool=new InheritableThreadLocal<>();



    /*Crate a re-usable utility method which will return same driver instance when we call it.*/
    public static WebDriver getDriver(){

        if (driverPool.get()==null){
            if (System.getProperty("BROWSER") == null) {
                browserType = ConfigurationReader.getProperty("browser");
            } else {
                browserType=System.getProperty("BROWSER");
            }
            /*we read our browserType from configuration.properties
                this way, we can control which browser is opened from outside our code, from configuration.properties.*/
            String browserType=ConfigurationReader.getProperty("browser");

        /*depending on the browserType that will be returned from configuration.properties file
            switch statement will determine the case, and open the matching browser.*/
            switch (browserType){
                case "remote-chrome":
                    try{
                        //assign your grid server address (AWS Public IPv4 address)
                        String gridAddress = "100.24.72.249";
                        URL url = new URL("http://"+gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e){
                        e.printStackTrace();
                    } break;

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case  "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());;
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driverPool.get();
    }

    /*This method will make sure our driver value is always null after using quit() method*/
    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit(); //this line will terminate the existing session. value will not even be null.
        }
        driverPool.remove();
    }
}
