package dhsFlashSelenium.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MeetingSurvey {
	WebDriver driver;
	
	@FindBy(id="kudosForm")
	public WebElement form;
	
	@FindBy(css="li[id^='kudos_question_']")
	public List<WebElement> questions;
	
	@FindBy(css="input[id^='kudos_option_']")
	List<WebElement> answers;
	
	@FindBy(css="button[title='Log In']")
	WebElement submitButton;
	
	public MeetingSurvey(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}
	
	public String getQuestion(int index) {
		String question = questions.get(index).getText();
		return question;
	}
	
	public void selectTrue(int index) {
		WebElement answer = answers.get(index);
		answer.click();
	}

	public void selectFalse(int index) {
		WebElement answer = answers.get(index + 1);
		answer.click();
	}

	public void clickSubmit() {
		submitButton.click();
	} 
}
