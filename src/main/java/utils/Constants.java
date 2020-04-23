package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constants {

	static Properties prop = new Properties();
	
	Constants() throws IOException {

		String currentDirectory = System.getProperty("user.dir");
		String propertyFilePath = currentDirectory + "/src/main/java/resources/config.properties";
		FileInputStream fis = new FileInputStream(propertyFilePath);
		prop.load(fis);

	}

	public static final String WAIT_EXPLICIT_SEC = prop.getProperty("wait.explicit.seconds");


}