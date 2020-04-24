package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Servicesss;

public class ApplicationPage {

	public static WebDriver driver;

	public static By searchMaginifyIcon = By.xpath(
			"//button[@class='btn--link site-header__icon site-header__search-toggle js-drawer-open-top']//*[local-name()='svg']");
	public static By searchTextField = By.xpath("//input[@placeholder='Search']");
	public static By prodList = By.xpath("//ul[@class='page-width list-view-items']//li//div//a");
	public static By addToCartButton = By.xpath("//button[@name='add']");
	public static By featuredCollectionLabel = By.xpath("//h2[contains(text(),'Featured collection')]");
	public static By featuredCollectionList = By.xpath("//ul[@class=\"grid grid--uniform grid--view-items\"]//li[1]");

	public static By sizeDropdown = By.xpath("//select[@id='SingleOptionSelector-1']");
	public static By sizeDropdownList = By.xpath("//select[@id='SingleOptionSelector-1']//option");
	public static By viewCartButton = By.xpath("//a[@class='cart-popup__cta-link btn btn--secondary-accent']");	
	public static By currentPrice = By.xpath("//tr[@class='cart__row'][1]//td[4]//div//span");
	public static By currentQuantity = By.xpath("//tr[@class='cart__row'][1]//td[3]//div//input");


	

	public ApplicationPage(WebDriver driver) {

		this.driver = driver;

	}

	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}

	public static void clickElement(WebDriver driver, By Xpath) {

		Servicesss.clickElement(driver, Xpath);

	}

	public static void waitForElementToBeClickable(By Xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	public static void sendData(WebDriver driver, By Xpath, String dataToSend) {
		Servicesss.sendKeysbyXpath(driver, Xpath, dataToSend);

	}

	public static void addCart(By List, String Text, WebDriver driver) {

		Servicesss.selectDataFromList(List, Text, driver);
		Servicesss.clickElement(driver, addToCartButton);

	}

	public static void addCart( WebDriver driver) {

		Servicesss.clickElement(driver, addToCartButton);

	}
	
	
	
	public static void wait(WebDriver driver, By Xpath) {

		Servicesss.waitForElementToBeClickable(driver, Xpath);

	}

	public static void goToFeaturedCollection(WebDriver driver, By Xpath) throws InterruptedException {

		WebElement ele = getWebElement(driver, Xpath);
		Servicesss.scrollDown(ele, driver);

	}
	

	public static void addMulSize(By drpdwn, String value, By list, WebDriver driver ) throws InterruptedException {
		
		Servicesss.addMulItem(drpdwn, value, list, driver );
		Servicesss.clickElement(driver, addToCartButton);

	}
	
	
	

	public static void closeBrowser(WebDriver driver) throws InterruptedException {

		Servicesss.closeBrowser(driver);

	}

}
