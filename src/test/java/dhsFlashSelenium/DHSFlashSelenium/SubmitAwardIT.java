package dhsFlashSelenium.DHSFlashSelenium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.CreateAward;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class SubmitAwardIT {
	WebDriver driver;
	WebDriverWait waitDriver;
	CreateAward createAward;
	String employee = "TestEmployee";
	String award = "TestAward";

	@Parameters({"browser", "environment"})
	@BeforeTest
	public void openBrowser(String browser, String environment) throws MalformedURLException {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName(browser);
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41:4444/wd/hub"),capability);

		waitDriver = new WebDriverWait (driver, 15);
		driver.get(environment);	
		createAward = new CreateAward(driver);
	}

	@Test (priority = 0)
	public void successfullySubmitAward() {
		assertTrue(createAward.selectEmployee(employee));
		assertTrue(createAward.selectAward(award));
		assertTrue(createAward.submitAward());
	}

	@Test (priority = 1)
	public void employeeMissingFromList() {
		assertTrue(createAward.selectEmployee(employee));
		assertFalse(createAward.selectAward(award));
		assertFalse(createAward.submitAward());
	}

	@Test (priority = 2)
	public void awardMissingFromList() {
		assertTrue(createAward.selectEmployee(employee));
		assertTrue(createAward.selectAward(award));
		assertFalse(createAward.submitAward());
	}
}
