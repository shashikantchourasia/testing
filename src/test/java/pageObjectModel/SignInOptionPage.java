package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInOptionPage {
	
	private static By prosper_loc = By.cssSelector("section[id='card-2']");
	private static By loginButton_loc = By.cssSelector("section[id='card-2'] div a span");
	
	public static void prosperLogIn(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement prosperButton = driver.findElement(prosper_loc);
		js.executeScript("arguments[0].scrollIntoView();", prosperButton);
		driver.findElement(loginButton_loc).click();
		
	}

}
