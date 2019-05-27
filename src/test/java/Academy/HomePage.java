package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initilizer() throws IOException {
		driver = initilizeDriver();
		log.info("Driver is initilized");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String userName, String password) throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Opened the page");

		LandingPage landingPage = new LandingPage(driver);
		landingPage.getSignIn().click();
		log.info("Clicked on sign in");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(userName);
		log.info("Entered the user name");
		loginPage.getPassword().sendKeys(password);
		log.info("Entered the password");
		loginPage.getLogin().click();
		log.info("Clicked on the login");

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "abcd@email.com";
		data[0][1] = "pass12341234";

		data[1][0] = "rtyj@email.com";
		data[1][1] = "passfghg";

		return data;
	}

	@AfterMethod
	public void closeDown() {
		driver.close();
		driver = null;
		log.info("Closed HomePage testing");
	}
}
