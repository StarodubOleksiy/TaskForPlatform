package tests;

import controllers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class BaseTest extends PageFactoryInitializer {
    @BeforeTest(alwaysRun=true)
    public void suiteSetup() throws Exception
    {
        detectBrowser(); //Detect browser which you are going to use
    }

    @BeforeMethod
    public void beforeMethod() throws Exception
    {
        System.out.println("Browser: "+Browser);
        System.out.println("WebsiteURL: "+WebsiteURL);
        new WebDriverFactory(); //Create Web Driver Factory to browser what you are going to use
        WebDriver driver = WebDriverFactory.createDriver(); //Create driver to your browser using Web Driver Factory
        setWebDriver(driver);//Set web driver which you have already created

        if(VideoFeature.toLowerCase().contains("enabledfailed"))
        {
            setupVideoRecordingFailedOnly();
        }
        else if(VideoFeature.toLowerCase().contains("enabledall"))
        {
            setupVideoRecordingAll();
        }
    }

    @AfterMethod(alwaysRun=true,enabled=true)
    public void afterMethod() throws Exception
    {
        Thread.sleep(2000);
        getWebDriver().quit();//Exit the driver which you have created
    }


}
