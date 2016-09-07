package dhsFlashSelenium.DHSFlashSelenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.GivePoint;

public class ViewEmployeeList extends AbstractTest {
	GivePoint pointPage;
	String listTitle = "Latest Kudos";

	@Test (priority = 0)
	public void viewEmployeeList() {
		pointPage = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(pointPage.getKudosList()));
		assertTrue(pointPage.getKudosList().isDisplayed());
		assertTrue(pointPage.getList().isDisplayed());
		assertEquals(listTitle, pointPage.getListTitleText());
		assertTrue(pointPage.getUsers().size() > 0);
	}
	
	@Test (priority = 1)
	public void viewEmployeePoints() {
		pointPage.getUsers().get(0);
	}
}
