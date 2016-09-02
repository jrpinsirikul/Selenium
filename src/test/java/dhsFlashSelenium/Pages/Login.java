package dhsFlashSelenium.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login {
	WebDriver driver;

	@FindBy(id="user_id")
	WebElement usernameTextBox;

	@FindBy(id="user_password")
	WebElement passwordTextBox;

	@FindBy(css="button[title='Log In']")
	WebElement loginButton;

	public Login(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}

	public void inputUsername(String username) {
		usernameTextBox.sendKeys(username);
	} 

	public void inputPassword(String password) {
		passwordTextBox.sendKeys(password);
	} 
	
	public void login(String username, String password) {
		inputUsername(username);
		inputPassword(password);
		loginButton.click();
	}
}