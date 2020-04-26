package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.BaseClass;
import utils.Services;
public class LandingPage extends BaseClass {

	public static WebDriver driver;

	public static By enterPasswordButton = By
			.xpath("//a[@class='js-modal-open-login-modal link--action btn btn--secondary']");
	public static By enterPasswordTextField = By.xpath("//input[@id='Password']");
	public static By passwordSubmitButton = By.xpath("//button[contains(text(),'Enter')]");

	public LandingPage(WebDriver driver) {

		this.driver = driver;

	}

	public static WebElement getWebElement(WebDriver driver, By Xpath) {

		WebElement webElement = driver.findElement(Xpath);

		return webElement;
	}

	public static void clickElement(WebDriver driver, By Xpath) {

		Services.clickElement(driver, Xpath);

	}

	public static void waitForElementToBeClickable(By Xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Xpath));

	}

	public static void sendData(WebDriver driver, By Xpath, String dataToSend) throws InterruptedException {
		Services.sendKeysbyXpath(driver, Xpath, dataToSend);

	}

}
