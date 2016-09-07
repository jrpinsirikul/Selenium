package dhsFlashSelenium.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAward {
	WebDriver driver;

	@FindBy(id="award-dropdown-id")
	WebElement awardSelection;

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
		Select dropDown = new Select(employeeDropdown);  
		dropDown.selectByVisibleText(employeeName);
		return true;
	} 

	public boolean selectAward(String awardName) {
		Select dropDown = new Select(awardSelection);  
		dropDown.selectByVisibleText(awardName);
		return true;
	} 
	
	public boolean submitAward() {
		submitButton.click();
		return true;
	}
}