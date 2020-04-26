
package cucumberOptions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import resources.BaseClass;

public class Listeners implements ITestListener {

	WebDriver driver;
	BaseClass b = new BaseClass();

	String filePath = "./screenshots";

	@Override
	public void onTestFailure(ITestResult result) {

		try {
          //  driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");

			b.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	  @Override
	    public void onStart(ITestContext arg0) {

	    }

	    @Override
	    public void onFinish(ITestContext arg0) {
	        
	    	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) { //

	}

	public void onTestSkipped(ITestResult arg0) { // TODO Auto-generated method

	}

	public void onTestStart(ITestResult arg0) { // TODO Auto-generated method

	}

	public void onTestSuccess(ITestResult arg0) { // TODO Auto-generated method

	}

}
