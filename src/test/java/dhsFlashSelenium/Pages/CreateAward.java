package dhsFlashSelenium.Pages;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAward {
	WebDriver driver;

	@FindBy(id="award-dropdown-id")
	WebElement awardDropdown;

	@FindBy(id="employee-dropdown-id")
	WebElement employeeDropdown;

	@FindBy(id="submit-button")
	WebElement submitButton;

	public CreateAward(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this);
	}

	public boolean selectEmployee(String employeeName) {
		Select select = new Select(employeeDropdown);  
		List<WebElement> options = select.getOptions();  
		for(WebElement we:options) {
			if(we.getText().equals(employeeName)) {
				return true;
			}
		}
		return false;
	} 

	public boolean selectAward(String awardName) {
		Select select = new Select(awardDropdown);  
		List<WebElement> options = select.getOptions();  
		for(WebElement we:options) {
			if(we.getText().equals(awardName)) {
				return true;
			}
		}
		return false;
	} 
	
	public boolean submitAward() {
		submitButton.click();
		return true;
	}
}