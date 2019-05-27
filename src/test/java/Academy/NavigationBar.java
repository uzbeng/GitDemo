package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class NavigationBar extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initilizer() throws IOException {
		driver = initilizeDriver();
		log.info("Driver is initilized");
		driver.get("http://qaclickacademy.com");
		log.info("Opened the page");
	}

	@Test()
	public void basePageNavigation() throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		Assert.assertTrue(landingPage.getNavBarElement().isDisplayed());
		// Assert.assertFalse(landingPage.getNavBarElement().isDisplayed());
		log.info("Checked the nav bar");

	}

	@AfterMethod
	public void closeDown() {
		driver.close();
		driver = null;
		log.info("Closed Nav Bar testing");
	}
}
