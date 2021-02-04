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

public class SeleniumSortingListOfTallestBuildingsTest extends BaseTest {


    @TestCaseId("TC_List_of_tallest_buildings_001")
    @Description("Verify sorting functionality for two columns (Rank and City) which are in the uppermost table ")
    @Features("https://en.wikipedia.org/wiki/List_of_tallest_buildings")
    @Test
    public void test1VerifySortingFunctionalityForColumnsRankAndCity() {
        ListOfTallestBuildings()
                .sortingInOrderByRank(SortingOrder.Up);//Click on the top cell of column to sort ranks in ascending order
        Assert.assertTrue(ListOfTallestBuildings().checkRankInTableSortedAscendingOrder());//Verify if column rank is sorted in ascending order
        ListOfTallestBuildings()
                .sortingInOrderByRank(SortingOrder.Down);//Click on the top cell of column to sort ranks in descending order
        Assert.assertFalse(ListOfTallestBuildings().checkRankInTableSortedAscendingOrder());;//Verify if column rank is sorted in descending order
        ListOfTallestBuildings()
                .sortingInOrderByCity(SortingOrder.Up); //Click on the top cell of column to sort cities in ascending order
        Assert.assertTrue(ListOfTallestBuildings().checkCitiesInTableSortedAscendingOrder());//Verify if column city is sorted in ascending order
        ListOfTallestBuildings()
                .sortingInOrderByCity(SortingOrder.Down); //Click on the top cell of column to sort cities in descending order
        Assert.assertFalse(ListOfTallestBuildings().checkCitiesInTableSortedAscendingOrder());//Verify if column city is sorted in descending order
    }


    @TestCaseId("TC_List_of_tallest_buildings_002")
    @Description("Verify the oldest building in this table is Empire State Building which was built in 1931 year")
    @Features("https://en.wikipedia.org/wiki/List_of_tallest_buildings")
    @Test
    public void testVerifyTheOldestBuildingIsEmpireStateBuilding() {
        ListOfTallestBuildings()
                .sortingInOrderByYear(SortingOrder.Up)//Click on the top cell of column to sort years in ascending order
                .verifyOldestBuilding("Empire State Building", "1931");//Verify the oldest building is Empire State Building which was built in 1931
    }
}
