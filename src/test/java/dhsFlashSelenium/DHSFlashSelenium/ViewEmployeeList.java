package dhsFlashSelenium.DHSFlashSelenium;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.GivePoint;

public class ViewEmployeeList extends AbstractTest {
	GivePoint pointPage;

	@Test (priority = 20)
	public void viewEmployeeList() {
		pointPage = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(pointPage.getKudosList()));
		assertTrue(pointPage.getKudosList().isDisplayed());
		assertTrue(pointPage.getListHeader().isDisplayed());
	}

	@Test (priority = 21)
	public void viewEmployeePoints() {
		if(pointPage.getUsers().size() != 0) {
			assertTrue(pointPage.usersHaveKudos());
		}
	}
}
