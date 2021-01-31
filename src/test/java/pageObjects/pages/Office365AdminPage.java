package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class Office365AdminPage extends PageFactoryInitializer {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-form-login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='cloud-devices-button']")
    private WebElement addCloudDevicesLink;

    @FindBy(xpath = "//span[contains(text(),'Office 365 Admin')]")
    private WebElement office365AdminSpan;


    @Step("Enter login of the user {0}")
    public Office365AdminPage enterLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Enter users password{0}")
    public Office365AdminPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click button to login")
    public Office365AdminPage clickOnLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Click button to add cloud service")
    public Office365AdminPage clickAddCloudDevicesLink() {
        addCloudDevicesLink.click();
        return this;
    }

    @Step("Click on <<Office 365 Admin>> span")
    public Office365AdminPage clickOnOffice365AdminSpan() {
        office365AdminSpan.click();
        return this;
    }

    public boolean verifyCreateNewOffice365PopUpWindowIsPresent()
    {
        return isElementPresent("//div[contains(text(),'Create new Office 365 connector')]");
    }


}
