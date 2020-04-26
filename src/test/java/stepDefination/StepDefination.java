package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/*import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;*/
import io.cucumber.junit.Cucumber;
import pageObjects.ApplicationPage;
import pageObjects.LandingPage;
import resources.BaseClass;
import utils.Services;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

@RunWith(Cucumber.class)
public class StepDefination extends BaseClass {

	String strExistingPrice;
	String strUpdatedPrice;
	int intUpdatedPrice;
	int existingQuantity;
	float intExistingPrice;

	@Given("^User is on landing page\"([^\"]*)\"$")
	public void user_is_on_landing_pagesomething(String strArg1) throws Throwable {
		driver = initializeDriver();
		driver.get(strArg1);
		driver.manage().window().maximize();

	}

	@When("^User login into application with password \"([^\"]*)\"$")
	public void user_login_into_application_with_password_something(String strArg1) throws Throwable {
		LandingPage.clickElement(driver, LandingPage.enterPasswordButton);
		LandingPage.sendData(driver, LandingPage.enterPasswordTextField, strArg1);
		LandingPage.clickElement(driver, LandingPage.passwordSubmitButton);

	}

	@Then("^Search a product (.+)$")
	public void search_a_product(String produtname) throws Throwable {
		ApplicationPage.clickElement(driver, ApplicationPage.searchMaginifyIcon);
		ApplicationPage.sendData(driver, ApplicationPage.searchTextField, produtname);
		WebElement enterAfterSearch = driver.findElement(ApplicationPage.searchTextField);
		enterAfterSearch.sendKeys(Keys.ENTER);

	}

	@And("^Add \"([^\"]*)\" product into the cart$")
	public void add_something_product_into_the_cart(String strArg1) throws Throwable {
		ApplicationPage.wait(driver, ApplicationPage.prodList);
		ApplicationPage.addCart(ApplicationPage.prodList, strArg1, driver);

	}

	@Then("^Quit the browser$")
	public void quit_the_browser() throws Throwable {

		ApplicationPage.closeBrowser(driver);

	}

	// Second TC
	@Then("^Go to View Cart screen$")
	public void go_to_view_cart_screen() throws Throwable {

		ApplicationPage.clickElement(driver, ApplicationPage.viewCartButton);

	}

	@And("^Increase the quantity and verify price should get updated accordngly$")
	public void increase_the_quantity_and_verify_price_should_get_updated_accordngly() throws Throwable {

		strExistingPrice = driver.findElement(ApplicationPage.currentPrice).getText();
		existingQuantity = Integer
				.parseInt(driver.findElement(ApplicationPage.currentQuantity).getAttribute("data-quantity-item"));

		intExistingPrice = Services.convertStrIntoFloat(strExistingPrice);

		Thread.sleep(2000);

		driver.findElement(ApplicationPage.currentQuantity).click();
		driver.findElement(ApplicationPage.currentQuantity).clear();
		int incrementQuantity = existingQuantity + 1;

		driver.findElement(ApplicationPage.currentQuantity).sendKeys(String.valueOf(incrementQuantity));
		Thread.sleep(3000);

		strUpdatedPrice = driver.findElement(ApplicationPage.currentPrice).getText();
		intUpdatedPrice = Services.convertStrRoundInteger(strUpdatedPrice);
		Assert.assertEquals(intUpdatedPrice,
				Services.calculatePrice(existingQuantity, intExistingPrice, incrementQuantity));
	}

	// Third TC

	@Then("^Go to featured collection list$")
	public void go_to_featured_collection_list() throws Throwable {

		ApplicationPage.goToFeaturedCollection(driver, ApplicationPage.featuredCollectionLabel);

	}

	@And("^Add a product \"([^\"]*)\" from the featured collection in to a cart$")
	public void add_a_product_something_from_the_featured_collection_in_to_a_cart(String strArg1) throws Throwable {

		ApplicationPage.addCart(ApplicationPage.featuredCollectionList, strArg1, driver);

	}

//Fourth TC
	
	@And("^Add \"([^\"]*)\" product into the cart with multiple sizes$")
	public void add_something_product_into_the_cart_with_multiple_sizes(String strArg1) throws Throwable {

		ApplicationPage.wait(driver, ApplicationPage.prodList);
		ApplicationPage.addCart(ApplicationPage.prodList, strArg1, driver);
		ApplicationPage.addMulSize(ApplicationPage.sizeDropdown, "M", ApplicationPage.sizeDropdownList, driver);
		ApplicationPage.addMulSize(ApplicationPage.sizeDropdown, "3XL", ApplicationPage.sizeDropdownList, driver);
		ApplicationPage.addCart(driver);

	}

}