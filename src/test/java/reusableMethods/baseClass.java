package reusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {

	static WebDriver driver;
	static Properties prop;
	static FileInputStream file;
//	String baseBrowser;
//	String baseUrl;

	static String projectPath = System.getProperty("user.dir");

	public static WebDriver getDrivers(String baseDriver) throws IOException {

		if (baseDriver.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\test\\java\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (baseDriver.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\src\\test\\java\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (baseDriver.equalsIgnoreCase("microsoft edge")) {
			System.setProperty("webdriver.edge.driver", projectPath + "\\src\\test\\java\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		return driver;

	}

	public static Properties getPropertyFile() throws IOException {

		prop = new Properties();
		file = new FileInputStream(projectPath + "\\src\\test\\java\\resources\\data.properties");
		prop.load(file);

		return prop;

	}

}
