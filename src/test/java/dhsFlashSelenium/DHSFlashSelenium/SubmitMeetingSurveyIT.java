package dhsFlashSelenium.DHSFlashSelenium;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import dhsFlashSelenium.Pages.MeetingSurvey;

public class SubmitMeetingSurveyIT extends AbstractTest {
	MeetingSurvey meetingSurvey;

	@Test (priority = 0)
	public void successfulLogin() {
		meetingSurvey = new MeetingSurvey(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(meetingSurvey.submitButton));
		meetingSurvey.submitMeetingSurvey();
	}
}
