package stepDefination;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import resources.base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefination extends base {

    @Given("^User is on landing page\"([^\"]*)\"$")
    public void user_is_on_landing_pagesomething(String strArg1) throws Throwable {

    	driver = initializeDriver();
    	driver.get(strArg1);
    	driver.manage().window().maximize();
    	
    
    }
    
    
    @When("^User login into application with password \"([^\"]*)\"$")
    public void user_login_into_application_with_password_something(String strArg1) throws Throwable {
    	
    	System.out.println("inside when methodhjbb");
     
    	LandingPage lPage= new LandingPage(driver);
    	lPage.clickElement(driver,lPage.enterPasswordButton);
    	lPage.sendData(driver, lPage.enterPasswordTextField, strArg1);
    	lPage.clickElement(driver,lPage.passwordSubmitButton);
    
    	
    	
    }

    @Then("^Home Page screen populated$")
    public void home_page_screen_populated() throws Throwable {

    
    }

    @Then("^Add the same product into the cart$")
    public void add_the_same_product_into_the_cart() throws Throwable {

    
    }

    @And("^Search a product$")
    public void search_a_product() throws Throwable {

    
    }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    


   


    
    
    
}