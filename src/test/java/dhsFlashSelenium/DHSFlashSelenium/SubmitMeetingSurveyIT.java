package dhsFlashSelenium.DHSFlashSelenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.junit.Assert.*;

import dhsFlashSelenium.Pages.MeetingSurvey;

public class SubmitMeetingSurveyIT extends AbstractTest {
	MeetingSurvey meetingSurvey;

	@Test (priority = 0)
	public void completeSurvey() {
		meetingSurvey = new MeetingSurvey(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(meetingSurvey.form));
		for (WebElement questions:meetingSurvey.questions) {
			assertNotNull(questions.getText());
			//assertEquals("Was the meeting useful?\nTRUE\nFALSE", questions.getText());
		}
		meetingSurvey.clickSubmit();
	}
}
