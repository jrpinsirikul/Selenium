package dhsFlashSelenium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MeetingSurvey {
	WebDriver driver;
	
	@FindBy(css="button[title='Log In']")
	public WebElement submitButton;

	public MeetingSurvey(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}

	public void clickSubmit() {
		submitButton.click();
	} 
	
	public void submitMeetingSurvey() {
		clickSubmit();
	}
}
