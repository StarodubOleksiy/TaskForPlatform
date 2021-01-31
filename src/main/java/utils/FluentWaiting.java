package utils;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import controllers.BaseMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

/**
 * @date Aug 18, 2018
 */

public class FluentWaiting extends BaseMethod
{
	public static WebDriver driver;

	/*To Wait Until Element to be Clickable*/
	public static void waitUntillElementToBeClickable(int TotalTimeInSeconds, int PollingTimeInMilliseconds, WebElement Element)
	{
		 FluentWait<WebDriver> ClickableWait = new FluentWait<WebDriver>(getWebDriver())
		            .withTimeout(Duration.ofSeconds(TotalTimeInSeconds))
		            .pollingEvery(Duration.ofMillis(PollingTimeInMilliseconds))
		            .ignoring(NoSuchElementException.class);
		 
		 ClickableWait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/*To Wait Until Element to be Selectable*/
	public static void waitUntillElementToBeSelected(int TotalTimeInSeconds, int PollingTimeInMilliseconds, WebElement Element)
	{
		 FluentWait<WebDriver> SelectableWait = new FluentWait<WebDriver>(getWebDriver())
		            .withTimeout(Duration.ofSeconds(TotalTimeInSeconds))
		            .pollingEvery(Duration.ofMillis(PollingTimeInMilliseconds))
		            .ignoring(NoSuchElementException.class);
		 SelectableWait.until(ExpectedConditions.elementToBeSelected(Element));
	}
	
	/*To Wait Until Element to be Visible*/
	public static void waitUntillElementToBeVisible(int TotalTimeInSeconds, int PollingTimeInMilliseconds, WebElement Element)
	{
		 FluentWait<WebDriver> visibleWait = new FluentWait<WebDriver>(getWebDriver())
		            .withTimeout(Duration.ofSeconds(TotalTimeInSeconds))
		            .pollingEvery(Duration.ofMillis(PollingTimeInMilliseconds))
		            .ignoring(NoSuchElementException.class);
	 		visibleWait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	/*To Wait for an Alert Window */
	public static void waitUntillAlertWindowsPopUp(int TotalTimeInSeconds, int PollingTimeInMilliseconds)
	{
FluentWait<WebDriver> alertWait = new FluentWait<WebDriver>(getWebDriver())
		            .withTimeout(Duration.ofSeconds(TotalTimeInSeconds))
		            .pollingEvery(Duration.ofMillis(PollingTimeInMilliseconds))
		            .ignoring(NoSuchElementException.class);
		 	 alertWait.until(ExpectedConditions.alertIsPresent());
	}
	
	/*To Wait Until Elements to be Visible*/
	public static void waitUntillVisibilityOfElements(int TotalTimeInSeconds, int PollingTimeInMilliseconds, List<WebElement> Elements)
	{
		FluentWait<WebDriver> visibleWait = new FluentWait<WebDriver>(getWebDriver())
		            .withTimeout(Duration.ofSeconds(TotalTimeInSeconds))
		            .pollingEvery(Duration.ofMillis(PollingTimeInMilliseconds))
		            .ignoring(NoSuchElementException.class);
		 		 visibleWait.until(ExpectedConditions.visibilityOfAllElements(Elements));
	}
	
	/*To Wait Until Web-Page Title to be Visible*/
	public static void waitForTitleToBe(int TotalTimeInSeconds, int PollingTimeInMilliseconds, String PageTitle)
	{
		FluentWait<WebDriver> titleWait = new FluentWait<WebDriver>(getWebDriver())
		            .withTimeout(Duration.ofSeconds(TotalTimeInSeconds))
		            .pollingEvery(Duration.ofMillis(PollingTimeInMilliseconds))
		            .ignoring(NoSuchElementException.class);
		 titleWait.until(ExpectedConditions.titleContains(PageTitle));
	}
}
