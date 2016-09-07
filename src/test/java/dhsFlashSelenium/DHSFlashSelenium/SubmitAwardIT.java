package dhsFlashSelenium.DHSFlashSelenium;

import org.testng.annotations.Test;
import dhsFlashSelenium.Pages.CreateAward;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class SubmitAwardIT extends AbstractTest {
	CreateAward createAward;
	String employee = "TestEmployee";
	String award = "TestAward";

	@Test (priority = 0)
	public void successfullySubmitAward() {
		createAward = new CreateAward(driver);
		assertTrue(createAward.selectEmployee(employee));
		assertTrue(createAward.selectAward(award));
		assertTrue(createAward.submitAward());
	}

	@Test (priority = 1)
	public void employeeMissingFromList() {
		assertTrue(createAward.selectEmployee(employee));
		assertFalse(createAward.selectAward(award));
		assertFalse(createAward.submitAward());
	}

	@Test (priority = 2)
	public void awardMissingFromList() {
		assertTrue(createAward.selectEmployee(employee));
		assertTrue(createAward.selectAward(award));
		assertFalse(createAward.submitAward());
	}
}
