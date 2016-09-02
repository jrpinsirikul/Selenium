package dhsFlashSelenium.DHSFlashSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import dhsFlashSelenium.Pages.Login;

import java.net.MalformedURLException;
import java.net.URL;

public class LoginIT {
	WebDriver driver;
	WebDriverWait waitDriver;
	Login loginPage;
	String username = "fakeusername";
	String password = "fakepassword";

	@Parameters({"browser", "environment"})
	@BeforeClass
	public void openBrowser(String browser, String environment) throws MalformedURLException {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName(browser);
		capability.setPlatform(Platform.LINUX);

		driver = new RemoteWebDriver(new URL("http://52.207.208.41:4444/wd/hub"),capability);

		waitDriver = new WebDriverWait (driver, 15);
		driver.get(environment);
		
		loginPage = new Login(driver);
	}

	@Test (priority = 0)
	public void successfulLogin() {
		waitDriver.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbox")));
		loginPage.login(this.username, this.password); 
	}

	@AfterClass
	public void takeDown() {
		driver.quit();
	}

}

