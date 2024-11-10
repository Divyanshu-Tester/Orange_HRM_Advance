package base_Class;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Drivers.DriverFactory;
import Utilities.ConfigReader;
import pageObjects.Leave.ApplyLeavePage;
import pageObjects.Leave.LeaveListPage;
import pageObjects.Login.Login_Page_Objects;

public class Base_Class extends DriverFactory

{
	public WebDriver driver;
	public LeaveListPage leaveListPage;
	public Login_Page_Objects loginPage;
	public ApplyLeavePage applyLeavePage;

	@Parameters("browserName")
	@BeforeMethod
	public void setup(String browserName) throws IOException {
		driver = getDriver(browserName);
		loginPage = new Login_Page_Objects(driver);
		leaveListPage = new LeaveListPage(driver);

		applyLeavePage = new ApplyLeavePage(driver);

	}

	// resuable method for apply leave
	public void applyLeave() throws InterruptedException {
		applyLeavePage.selectLeaveType();
		applyLeavePage.selectFromDate(ConfigReader.getConfigPropertyData("startDate"));
		applyLeavePage.selectToDate(ConfigReader.getConfigPropertyData("endDate"));
		applyLeavePage.clickApplyLeave();
	}

	// @AfterMethod()
	// public void tearDown() { driver.quit(); }

}
