package dhsFlashSelenium.DHSFlashSelenium;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.GivePoint;

public class GivePointTest extends AbstractTest {
	GivePoint givePoint;
	String employeeName = "John Doe";

	@Test (priority = 0)
	public void submitPointForm() {
		givePoint = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getPointForm()));
		givePoint.selectColleague(employeeName);
		givePoint.clickGivePoint();
	}
	
	@Test (priority = 1)
	public void submitEmptyPointForm() {
		givePoint = new GivePoint(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(givePoint.getPointForm()));
		givePoint.clickGivePoint();
	}

}
