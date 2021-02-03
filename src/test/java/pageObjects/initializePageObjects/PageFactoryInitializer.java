/**
 *
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.ListOfTallestBuildings;


/**
 * @date Aug 18, 2018
 */
public class PageFactoryInitializer extends BaseMethod {

    public ListOfTallestBuildings ListOfTallestBuildings() {
        return PageFactory.initElements(getWebDriver(), ListOfTallestBuildings.class);
    }
}
