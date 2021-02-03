package tests;

import controllers.ApplicationConfigReader;
import org.aspectj.lang.annotation.Before;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.data.SortingOrder;
import pageObjects.pages.ListOfTallestBuildings;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

public class SeleniumCreateOffice365AdminTest extends BaseTest {


    @TestCaseId("TC_Signup_001")
    @Description("Verify incorrect login signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void test1() {
        ListOfTallestBuildings()
                .sortingInOrderByRank(SortingOrder.Up);//1
        Assert.assertTrue(ListOfTallestBuildings().checkRankInTableSortedDescendingOrder());
        ListOfTallestBuildings()
                .sortingInOrderByRank(SortingOrder.Down);//74
        Assert.assertFalse(ListOfTallestBuildings().checkRankInTableSortedDescendingOrder());
        ListOfTallestBuildings()
                .sortingInOrderByCity(SortingOrder.Up); //Abu Dhabi
        Assert.assertTrue(ListOfTallestBuildings().checkCitiesInTableSortedDescendingOrder());
        ListOfTallestBuildings()
                .sortingInOrderByCity(SortingOrder.Down); //Xi'an
        Assert.assertFalse(ListOfTallestBuildings().checkCitiesInTableSortedDescendingOrder());
    }


    @TestCaseId("TC_Signup_001")
    @Description("Verify incorrect login signup to Stone Edge Trading application")
    @Features("Stone Edge Trading signup page")
    @Test
    public void test2() {
        ListOfTallestBuildings()
                .sortingInOrderByYear(SortingOrder.Up)
                .verifyOldestBuilding("Empire State Building", "1931");
    }
}
