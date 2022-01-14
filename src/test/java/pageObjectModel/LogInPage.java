package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	private By username_loc = By.id("test_automation_username");
	private By password_loc = By.id("password");
	private By submit_loc = By.id("test_automation_submit");

	public WebElement getUserID() {
		return driver.findElement(username_loc);
	}

	public WebElement getPassword() {
		return driver.findElement(password_loc);
	}

	public void clickSubmit() {
		driver.findElement(submit_loc).click();
	}

}
