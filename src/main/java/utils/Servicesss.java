package utils;

//import static testngConstants.Constants.WAIT_EXPLICIT_SEC;
//import static utils.Constants.WAIT_EXPLICIT_SEC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Servicesss {

	public static void clickElement(WebDriver driver, By Xpath) {

		waitForElementToBeClickable(driver, Xpath);

		getWebElement(driver, Xpath).click();

	}

	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}

	public static void waitForElementToBeClickable(WebDriver driver, By Xpath) {

		// System.out.println(WAIT_EXPLICIT_SEC);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	public static void scrollDown(WebElement element, WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("window.scrollBy(0,-200);", element);
		Actions actions = new Actions(driver);
		Thread.sleep(3000);
		actions.moveToElement(element);

	}

	public static void sendKeysbyXpath(WebDriver driver, By Xpath, CharSequence... keysToSend) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Xpath));
		WebElement wl = getWebElement(driver, Xpath);
		wl.clear();
		wl.sendKeys(keysToSend);
	}

	public static void selectDataFromList(By List, String Text, WebDriver driver) {

		List<WebElement> list = driver.findElements(List);

		for (int i = 0; i < list.size(); i++)

		{

			if (list.get(i).getText().contains(Text)) {

				list.get(i).click();

				break;

			}

		}

	}

	public static void closeBrowser(WebDriver driver) throws InterruptedException {

		if (driver == null) {
			return;
		}
		driver.quit();
		driver = null;

	}

	public static void addMulItem(By drpdown, String Name, By dropdownList, WebDriver driver) {

		driver.findElement(drpdown).click();
		List<WebElement> list = driver.findElements(dropdownList);

		for (int i = 0; i < list.size(); i++)

		{
			// System.out.println(list.get(i).getText());
			if (list.get(i).getText().contentEquals(Name))

			{
				list.get(i).click();
				break;
			}
		}

	}

}
