package dhsFlashSelenium.DHSFlashSelenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public abstract class AbstractTest {
	WebDriver driver;
	WebDriverWait waitDriver;

	@Parameters({"browser", "environment"})
	@BeforeClass
	public void openBrowser(String browser, String environment) throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();
		if (browser.equals("chrome")) {
			capability = DesiredCapabilities.chrome();
		} else if (browser.equals("firefox")) {
			capability = DesiredCapabilities.firefox();
		}
		capability.setBrowserName(browser);
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41/wd/hub"),capability);

		waitDriver = new WebDriverWait (driver, 15);
		driver.get(environment);
	}

	@AfterClass
	public void takeDown() {
		driver.quit();
	}
}
