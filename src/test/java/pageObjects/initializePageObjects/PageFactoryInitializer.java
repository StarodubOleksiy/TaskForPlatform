/**
 *
 */
package pageObjects.initializePageObjects;

import org.openqa.selenium.support.PageFactory;

import controllers.BaseMethod;
import pageObjects.pages.ListOfTallestBuildings;


/**
 * author Oleksiy Starodub
 * @date February 04, 2021
 */

public class PageFactoryInitializer extends BaseMethod {

    public ListOfTallestBuildings ListOfTallestBuildings() {
        return PageFactory.initElements(getWebDriver(), ListOfTallestBuildings.class);
    }
}
