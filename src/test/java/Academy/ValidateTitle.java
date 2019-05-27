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

public class ValidateTitle extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeMethod
	public void initilizer() throws IOException {
		driver = initilizeDriver();
		log.info("Initilized the driver");
		driver.get("http://qaclickacademy.com");
		log.info("open the page");
	}

	@Test()
	public void basePageNavigation() throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		Assert.assertEquals("FEATURED-COURSES", landingPage.getTitle().getText());
		log.info("Checked the page title");

	}

	@AfterMethod
	public void closeDown() {
		driver.close();
		driver = null;
		log.info("Closed ValidateTitle testing");
	}
}
