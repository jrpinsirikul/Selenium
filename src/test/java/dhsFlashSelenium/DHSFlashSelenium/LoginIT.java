package dhsFlashSelenium.DHSFlashSelenium;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.GivePoint;
import dhsFlashSelenium.Pages.Login;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class LoginIT extends AbstractTest {
	Login loginPage;
	String username = "johndoe";
	String password = "letmein";
	String wrongUsername = "wrongUsername";
	String wrongPassword = "wrongPassword";
	String homePageTitle = "Home | kudos";

	@Test (priority = 0)
	public void unSuccessfulLogin() {
		loginPage = new Login(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.getLoginBox()));
		loginPage.login(this.wrongUsername, this.wrongPassword);
		assertTrue(loginPage.getLoginBox().isDisplayed());
	}
	
	@Test (priority = 1)
	public void successfulLogin() {
		loginPage = new Login(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.getLoginBox()));
		loginPage.login(this.username, this.password);
		GivePoint homePage = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(homePage.getPointForm()));
		assertEquals(homePageTitle, homePage.getPageTitle());
	}
}

