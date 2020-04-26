package cucumberOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
 import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.xml.XmlSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

 
public class  ExtentReportNG implements IReporter,ISuiteListener,ITestListener {
public static  ExtentReports extent;
public static   ExtentTest currentTest; 
public  static HashMap<String, ExtentTest> map;
  ExtentHtmlReporter htmlReporter;

   
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    	

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }
 
        extent.flush();
        
    }
 
    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;

 
        if (tests.size() > 0) {
       for (ITestResult result : tests.getAllResults()) {
            	
    test = map.get(result.getMethod().getMethodName());
    	
            
            for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null)
				message = result.getThrowable().getMessage();

                test.log(status, message);
 
            }
        }
    }
 


	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
		}

		
		


	public void onStart(ISuite arg0) {
	       map = new HashMap<String, ExtentTest> (); 
		   htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\TestReport.html");
	       extent = new ExtentReports();
	       extent.attachReporter(htmlReporter);
	        
		
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		 
        ExtentTest test =   extent.createTest(arg0.getName());
		map.put(arg0.getName(), test);
		
		currentTest = test;
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@AfterMethod
	public void afterMethod() {
	    extent.flush();
	}


	
	
	
}