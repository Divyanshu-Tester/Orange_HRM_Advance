package base_Class;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Drivers.DriverFactory;
import Utilities.ConfigReader;
import pageObjects.Dashboard.Page_Object_Dashboard;
import pageObjects.Directory.Page_Object_Directory;
import pageObjects.Leave.ApplyLeavePage;
import pageObjects.Leave.EntitlementsPage;
import pageObjects.Leave.LeaveListPage;
import pageObjects.Leave.MyLeavePage;
import pageObjects.Login.Login_Page_Objects;
import pageObjects.Profile.Dynamic_Profile;

//public class Base_Class

public class Base_Class extends DriverFactory {

	//public WebDriver driver;
	public LeaveListPage leaveListPage;
	public Login_Page_Objects loginPage;
	public ApplyLeavePage applyLeavePage;
	public Page_Object_Dashboard dashboardPage;
	public Dynamic_Profile profileName;
	public MyLeavePage  myLeavePage;
	public EntitlementsPage entitlementsPage;
	public Page_Object_Directory directoryObj;

	@Parameters("browserName")
	
	public void setup(String browserName) throws IOException {

		 driver = getDriver(browserName);
		 driver.manage().deleteAllCookies();
		System.out.println("Thread: " + Thread.currentThread().getName() +
			    ", Driver Instance: " + driver);
		loginPage = new Login_Page_Objects(driver);
		leaveListPage = new LeaveListPage(driver);

		applyLeavePage = new ApplyLeavePage(driver);
		profileName = new Dynamic_Profile(driver);
		myLeavePage= new MyLeavePage(driver);
		 entitlementsPage= new EntitlementsPage(driver);
		  directoryObj=new Page_Object_Directory(driver);

		// **Arrange**: Prepare for each test
		loginPage.loadLoginPage();
		loginPage.Default_Username(ConfigReader.getConfigPropertyData("username"));
		loginPage.Default_Password(ConfigReader.getConfigPropertyData("password"));
		dashboardPage = loginPage.Click_Login();
		Assert.assertEquals(dashboardPage.dashboardLoaded(), "Dashboard", "Dashboard did not load sucessfully");

	}
	@Parameters("browserName")
	@BeforeMethod(groups = { "smoke" }, alwaysRun=true)
	public void setUpApp(String browserName) throws IOException
	{
		driver = getDriver(browserName);
		// **Arrange**: Prepare for each test
		loginPage = new Login_Page_Objects(driver);
				loginPage.loadLoginPage();
				loginPage.Default_Username(ConfigReader.getConfigPropertyData("username"));
				loginPage.Default_Password(ConfigReader.getConfigPropertyData("password"));
				dashboardPage = loginPage.Click_Login();
				Assert.assertEquals(dashboardPage.dashboardLoaded(), "Dashboard", "Dashboard did not load sucessfully");

	}

	// resuable method for apply leave
	public void applyLeave(String startDate, String endDate, String monthName) throws InterruptedException {

		applyLeavePage.selectLeaveType();
		applyLeavePage.selectFromDate(startDate, monthName);
		applyLeavePage.selectToDate(endDate, monthName);
		applyLeavePage.clickApplyLeave();
	}

	

	
	  @AfterMethod(groups= {"smoke"}, alwaysRun=true) 
	  public void closeBrowser() { 
		  tearDown();
		  }
	 
	 

}
