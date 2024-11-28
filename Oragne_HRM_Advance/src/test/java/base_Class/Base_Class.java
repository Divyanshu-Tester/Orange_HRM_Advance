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
import pageObjects.Leave.ApplyLeavePage;
import pageObjects.Leave.LeaveListPage;
import pageObjects.Login.Login_Page_Objects;

<<<<<<< HEAD

public class Base_Class
=======
public class Base_Class extends DriverFactory
>>>>>>> refs/remotes/origin/master

{
<<<<<<< HEAD
  public WebDriver driver ;

  @BeforeMethod
  public void Launch_Chrome()
  {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

  }
=======
	public WebDriver driver;
	public LeaveListPage leaveListPage;
	public Login_Page_Objects loginPage;
	public ApplyLeavePage applyLeavePage;
	public Page_Object_Dashboard dashboardPage;

	@Parameters("browserName")
	@BeforeMethod(groups= {"smoke"})
	public void setup(String browserName) throws IOException {
		
		driver = getDriver(browserName);
		System.out.println("driver instance value"+ driver);
		loginPage = new Login_Page_Objects(driver);
		leaveListPage = new LeaveListPage(driver);

		applyLeavePage = new ApplyLeavePage(driver);
		
		// **Arrange**: Prepare for each test
		loginPage.loadLoginPage();
		loginPage.Default_Username(ConfigReader.getConfigPropertyData("username"));
		loginPage.Default_Passowrd(ConfigReader.getConfigPropertyData("password"));
		dashboardPage =	loginPage.Click_Login();
		Assert.assertEquals(dashboardPage.dashboardLoaded(), "Dashboard","Dashboard did not load sucessfully");

	}

	// resuable method for apply leave
	public void applyLeave(String startDate, String endDate,String monthName) throws InterruptedException {
	
		applyLeavePage.selectLeaveType();
		applyLeavePage.selectFromDate(startDate,monthName);
		applyLeavePage.selectToDate(endDate,monthName);
		applyLeavePage.clickApplyLeave();
	}

	// @AfterMethod(groups= {"smoke"})
	// public void tearDown() { driver.quit(); }
>>>>>>> refs/remotes/origin/master

}
