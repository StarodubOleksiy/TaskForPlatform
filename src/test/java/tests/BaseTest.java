package tests;

import controllers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.initializePageObjects.PageFactoryInitializer;

public class BaseTest extends PageFactoryInitializer {
    @BeforeTest(alwaysRun=true)
    public void suiteSetup() throws Exception
    {
        detectBrowser(); //Detect browser which you are going to use
    }

    @BeforeClass
    public void beforeClass() throws Exception
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

    @AfterClass(alwaysRun=true,enabled=true)
    public void afterClass() throws Exception
    {
        Thread.sleep(2000);
        getWebDriver().quit();//Exit the driver which you have created
    }


}
