package test_Cases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.ConfigReader;
import base_Class.Base_Class;
import pageObjects.Dashboard.Page_Object_Dashboard;

public class TestLeaveList extends Base_Class {

	@Test(priority = 0, enabled = false, description = "verify that leave list page loads successfully with no records")
	public void verifyLeaveListPageShowsNoRecords() throws InterruptedException {
		// **Arrange**: setup done in @beforeMethod
		dashboardPage.clickOnLeaveTab();

		// **Act**: Perform action to load Leave List page
		String leavePageTitle = leaveListPage.leavePageLoaded();
		String noRecordsMessage = leaveListPage.leaveListPageNoRecordMessage().trim();

		// **Assert**: Validate that no records are found
		Assert.assertEquals(leavePageTitle, "Leave", "Leave page did not load sucessfully");
		Assert.assertEquals(noRecordsMessage, "No Records Found", "No Records Found message not displayed!");

	}

	@Test(priority = 1, enabled = false, description = "verify that leave list page loads successfully with records")
	public void verifyLeaveListPageShowsRecords() throws InterruptedException {

		// **Arrange**: Set up by applying a leave
		dashboardPage.clickOnLeaveTab();
		Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave", "Leave page did not load successfully!");
		leaveListPage.clickOnApplyTab();
		Assert.assertEquals(applyLeavePage.applyleavePageLoaded(), "Apply Leave", "Apply Leave page did not load!");

		// apply leave
		applyLeave();

		// **Act**: Navigate back to Leave List and fetch records
		dashboardPage.clickOnLeaveTab();

		// **Assert**: Verify that leave records are present
		Assert.assertTrue(leaveListPage.leaveListPageWithRecords(), "No one has applied the leave ");

	}

	@Test(priority = 2, enabled = false, description = "verify date range filter with no records")
	public void verifyFilteringLeaveWithNoRecords() {
		// **Arrange**: setup done in @beforeMethod
		dashboardPage.clickOnLeaveTab();
		Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave", "Failed to load Leave page");

		// **Act**: Apply the date range filter
		leaveListPage.applyDateFilter(ConfigReader.getConfigPropertyData("startDate"),
				ConfigReader.getConfigPropertyData("endDate"),ConfigReader.getConfigPropertyData("monthName"));

		// **Assert**: Verify no records are found for the given date range
		Assert.assertEquals(leaveListPage.leaveListPageNoRecordMessage().trim(), "No Records Found",
				"Expected 'No Records Found' message not displayed for empty date range.");
	}

	@Test(priority = 3, enabled = false, description = "verify date range filter with records")
	public void verifyFilteringLeaveWithRecords() throws InterruptedException {

		// **Arrange**: Set up by applying a leave
		dashboardPage.clickOnLeaveTab();
		Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave", "Leave page did not load successfully!");
		leaveListPage.clickOnApplyTab();
		Assert.assertEquals(applyLeavePage.applyleavePageLoaded(), "Apply Leave", "Apply Leave page did not load!");

		// apply leave
		applyLeave();
		dashboardPage.clickOnLeaveTab();
		Assert.assertTrue(leaveListPage.leaveListPageWithRecords(), "No one has applied the leave ");

		// **Act**: Apply the date range filter
		leaveListPage.applyDateFilter(ConfigReader.getConfigPropertyData("startDate"),
				ConfigReader.getConfigPropertyData("endDate"),ConfigReader.getConfigPropertyData("monthName"));

		// **Assert**: Verify that leave records are present
		Assert.assertTrue(leaveListPage.leaveListPageWithRecords(), "No one has applied the leave ");
	}

	@Test(priority = 4, enabled = true, description = "verify reset  filter with records")
	public void verifyResetDateFilter() throws InterruptedException {
		// **Arrange**: Navigate to Leave List Page and enter a specific date range
		dashboardPage.clickOnLeaveTab();
		leaveListPage.clickOnApplyTab();
		applyLeave();
		dashboardPage.clickOnLeaveTab();
		leaveListPage.applyDateFilter(ConfigReader.getConfigPropertyData("startDate"),
				ConfigReader.getConfigPropertyData("endDate"),ConfigReader.getConfigPropertyData("monthName"));

		// check records with in the applied date range
		List<WebElement> filteredRecords = leaveListPage.getLeaveRecords();

		// **Act**: Click on Reset button
		leaveListPage.clickResetFilterButton();
		
		//**Assert**:verify reset btn working fine

	}
	
	
	
	@Test(priority = 5, enabled=false,description = "Verify filtering leaves with Pending status (default) and no records")
	public void verifyFilteringLeavesWithPendingStatusAndNoRecords()  {
		// **Arrange**: Navigate to Leave List Page and enter a specific date range
				dashboardPage.clickOnLeaveTab();
				Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave", "Leave page did not load successfully!");
				
				
				// **Assert**: Verify Pending Approval is selected by default
			    String defaultStatus = leaveListPage.getSelectedLeaveStatus();
			    Assert.assertEquals(defaultStatus, "Pending Approval", "Default status is not 'Pending Approval'!");
			    
			    
			 // **Act**: Apply the date range filter
				leaveListPage.applyDateFilter(ConfigReader.getConfigPropertyData("startDate"),
						ConfigReader.getConfigPropertyData("endDate"),ConfigReader.getConfigPropertyData("monthNameLeaveList"));
				
				// **Assert**: Verify "No Records Found" message is displayed
				Assert.assertEquals(leaveListPage.leaveListPageNoRecordMessage().trim(), "No Records Found",
						"Expected 'No Records Found' message not displayed for empty date range.");
				
				// **Act**: Reset the filter
			    leaveListPage.clickResetFilterButton();
		
			 // **Assert**: Verify default filter values after reset
			    Assert.assertEquals(leaveListPage.getSelectedLeaveStatus(), "Pending Approval", "Status did not reset correctly!");
	}
	
	}


