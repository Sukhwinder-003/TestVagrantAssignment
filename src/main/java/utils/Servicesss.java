package utils;

import static utils.Constants.WAIT_EXPLICIT_SEC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Servicesss {

	public static void clickElement(WebDriver driver, By Xpath) {

		System.out.println("in servicess");
		System.out.println(Xpath);
		System.out.println(driver);
		waitForElementToBeClickable(driver,Xpath);
		
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@2");
		
		
		getWebElement(driver, Xpath).click();

	}

	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}


	public static void waitForElementToBeClickable(WebDriver driver, By Xpath) {


		//System.out.println(WAIT_EXPLICIT_SEC);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	
	public static void sendKeysbyXpath(WebDriver driver, By Xpath, CharSequence... keysToSend) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Xpath));
		WebElement wl = getWebElement(driver, Xpath);
		wl.clear();
		wl.sendKeys(keysToSend);
	}
	
	


}
