package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	By email = By.cssSelector("input[id='user_email']");
	By pswrd = By.cssSelector("[type='password']");
	By login = By.cssSelector("input[type='submit']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(pswrd);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
