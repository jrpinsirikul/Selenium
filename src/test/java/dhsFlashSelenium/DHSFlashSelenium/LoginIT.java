package dhsFlashSelenium.DHSFlashSelenium;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import dhsFlashSelenium.Pages.Login;

public class LoginIT extends AbstractTest {
	Login loginPage;
	String username = "fakeusername";
	String password = "fakepassword";

	@Test (priority = 0)
	public void successfulLogin() {
		loginPage = new Login(driver);
		waitDriver.until(ExpectedConditions.visibilityOf(loginPage.loginBox));
		loginPage.login(this.username, this.password); 
	}
}

