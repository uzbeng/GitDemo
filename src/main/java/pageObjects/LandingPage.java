package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	By signIn = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center>h2");
	By navBar = By.cssSelector(".navbar-collapse.collapse");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSignIn() {
		return driver.findElement(signIn);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavBarElement() {
		return driver.findElement(navBar);
	}
}
