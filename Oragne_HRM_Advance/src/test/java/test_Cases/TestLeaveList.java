package test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.ConfigReader;
import base_Class.Base_Class;
import pageObjects.Dashboard.Page_Object_Dashboard;


	public class TestLeaveList extends Base_Class {

		@Test(priority = 0, enabled=true,description = "verify that leave list page loads successfully with no records")
		public void testLeaveListPageWithNoRecords() throws InterruptedException {
			loginPage.loadLoginPage();
			loginPage.Default_Username(ConfigReader.getConfigPropertyData("username"));
			loginPage.Default_Passowrd(ConfigReader.getConfigPropertyData("password"));
			Page_Object_Dashboard  dashboardPage =	loginPage.Click_Login();
			Assert.assertEquals(dashboardPage.dashboardLoaded(), "Dashboard");
			dashboardPage.clickOnLeaveTab();
			Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave");
			Assert.assertEquals(leaveListPage.leaveListPageNoRecordMessage().trim(), "No Records Found");

		}
		
		@Test(priority = 1, description = "verify that leave list page loads successfully with records")
		public void testLeaveListPageWithRecords() throws InterruptedException {
			loginPage.loadLoginPage();
			loginPage.Default_Username(ConfigReader.getConfigPropertyData("username"));
			loginPage.Default_Passowrd(ConfigReader.getConfigPropertyData("password"));
			Page_Object_Dashboard  dashboardPage =	loginPage.Click_Login();
			Assert.assertEquals(dashboardPage.dashboardLoaded(), "Dashboard");
			dashboardPage.clickOnLeaveTab();
			Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave");
			leaveListPage.clickOnApplyTab();
			Assert.assertEquals(applyLeavePage.applyleavePageLoaded(), "Apply Leave");
			applyLeave();
			dashboardPage.clickOnLeaveTab();
		Assert.assertTrue(leaveListPage.leaveListPageWithRecords(),"No one has applied the leave ");
			
		}
		
		

	}


