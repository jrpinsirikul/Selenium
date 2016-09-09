package dhsFlashSelenium.DHSFlashSelenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.GivePoint;
import dhsFlashSelenium.Pages.Login;

public class GivePointTest extends AbstractTest {
	GivePoint givePoint;
	Login loginPage;
	String username = "johndoe";
	String password = "letmein";
	String employeeName = "John Doe";
	String homePageTitle = "Home | kudos";
	
	@Test (priority = 10)
	public void login() {
		loginPage = new Login(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.getLoginBox()));
		loginPage.login(this.username, this.password);
		GivePoint homePage = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(homePage.getPointForm()));
		assertEquals(homePageTitle, homePage.getPageTitle());
	}

	@Test (priority = 11)
	public void submitPointForm() {
		givePoint = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getPointForm()));
		givePoint.selectColleague(employeeName);
		givePoint.clickGivePoint();
	}
	
	@Test (priority = 12)
	public void submitEmptyPointForm() {
		givePoint = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getPointForm()));
		givePoint.clickGivePoint();
	}

}
