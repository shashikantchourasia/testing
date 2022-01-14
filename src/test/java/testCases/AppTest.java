package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelData;
import listeners.Listeners;
import pageObjectModel.LogInPage;
import pageObjectModel.SignInOptionPage;
import reusableMethods.baseClass;

public class AppTest {
	WebDriver driver;
	Properties prop;
	String projectPath;
	String baseBrowser;
	String baseUrl;
	
	private static Logger log = LogManager.getLogger(AppTest.class);

	@BeforeTest
	public void initializer() throws IOException {
		prop = baseClass.getPropertyFile();
		baseBrowser = prop.getProperty("browser");
		driver = baseClass.getDrivers(baseBrowser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

	}

	@Test(dataProviderClass = ExcelData.class, dataProvider = "getData")
	public void LoginIn(String userId, String password) throws IOException {

		log.debug("opening the url");
		Listeners.thread.get().info("opening the url");
		baseUrl = prop.getProperty("url");
		driver.get(baseUrl);
		driver.manage().window().maximize();
		SignInOptionPage.prosperLogIn(driver);

		LogInPage page = new LogInPage(driver);
		page.getUserID().sendKeys(userId);
		page.getPassword().sendKeys(password);
		page.clickSubmit();

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
