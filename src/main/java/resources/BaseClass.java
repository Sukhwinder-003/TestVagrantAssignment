package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		String currentDirectory = System.getProperty("user.dir");
		String propertyFilePath = currentDirectory + "/src/main/java/resources/config.properties";
		FileInputStream fis = new FileInputStream(propertyFilePath);
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName+" started");

		if (browserName.equals("chrome")) {
			String currentDir = System.getProperty("user.dir");
			String ChromeDriverPath = currentDir + "/Drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			String currentDirr = System.getProperty("user.dir");
			String FirefoxDriverPath = currentDirr + "/Drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/" + result + "SS.png"));

	}

}
