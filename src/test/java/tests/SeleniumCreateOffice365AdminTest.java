package tests;

import controllers.ApplicationConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SeleniumCreateOffice365AdminTest extends BaseTest {

    @TestCaseId("TC_Signup_001")
    @Description("Verify incorrect login signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void testSTEIncorrectLoginSignup1() throws Exception {
      System.out.println("Testing is working");
    }
}
