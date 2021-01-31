/**
 *
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.Office365AdminPage;


/**
 * @date Aug 18, 2018
 */
public class PageFactoryInitializer extends BaseMethod {

    public Office365AdminPage Office365AdminPage() {
        return PageFactory.initElements(getWebDriver(), Office365AdminPage.class);
    }
}
