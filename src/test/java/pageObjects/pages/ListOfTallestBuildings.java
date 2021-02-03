package pageObjects.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.data.SortingOrder;
import pageObjects.initializePageObjects.PageFactoryInitializer;
import ru.yandex.qatools.allure.annotations.Step;

public class ListOfTallestBuildings extends PageFactoryInitializer {

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//th[contains(text(),'Year')]")
    private WebElement yearSortingButton;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//th[contains(text(),'Rank')]")
    private WebElement rankSortingButton;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//th[contains(text(),'City')]")
    private WebElement citySortingButton;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//tbody//tr[1]//td[1]")
    private WebElement rankCellInFirstRow;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//tbody//tr[2]//td[1]")
    private WebElement rankCellInSecondRow;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//tbody//tr[1]//td[4]")
    private WebElement cityCellInFirstRow;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//tbody//tr[2]//td[4]")
    private WebElement cityCellInSecondRow;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//tbody//tr[1]//td//a")
    private WebElement passwordInput;

    @FindBy(xpath = "//table[contains(@class, 'wikitable') and contains(@class, 'jquery-tablesorter')][1]//tbody//tr[1]")
    private WebElement firstRowOfTable;


    @Step("Verify if oldest building is Empire State Building {0} {1}")
    public ListOfTallestBuildings verifyOldestBuilding(String buildingName,String year) {
        Assert.assertTrue(firstRowOfTable.getText().contains(year));
        Assert.assertTrue(firstRowOfTable.getText().contains(buildingName));
          return this;
    }


    @Step("Sorting buildings in order by year {0}")
    public ListOfTallestBuildings sortingInOrderByYear(SortingOrder order) {
        sortingColumnInOrder(yearSortingButton,order);
        return this;
    }

    @Step("Sorting buildings in order by rank {0}")
    public ListOfTallestBuildings sortingInOrderByRank(SortingOrder order) {
        sortingColumnInOrder(rankSortingButton,order);
        return this;
    }

    @Step("Sorting buildings in order by city {0}")
    public ListOfTallestBuildings sortingInOrderByCity(SortingOrder order) {
        sortingColumnInOrder(citySortingButton,order);
        return this;
    }


    @Step("Sorting data into tables in a certain order{0} {1}")
    private ListOfTallestBuildings sortingColumnInOrder(WebElement element, SortingOrder order) {
        scrollIntoView(element);
        while (!element.getAttribute("class").contains(order.getOrder()))
            element.click();
        return this;
    }

    private boolean checkDataInColumnSortedDescendingOrder(WebElement firstColumnElement, WebElement secondColumnElement) {
        if (firstColumnElement.getText().compareTo(secondColumnElement.getText()) == -1)
            return true;
        else return false;
    }

    public boolean checkCitiesInTableSortedDescendingOrder() {
        return checkDataInColumnSortedDescendingOrder(cityCellInFirstRow, cityCellInSecondRow);
    }

    public boolean checkRankInTableSortedDescendingOrder() {
        return checkDataInColumnSortedDescendingOrder(rankCellInFirstRow, rankCellInSecondRow);
    }


}
