package test_Cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.ConfigReader;
import base_Class.Base_Class;
import pageObjects.Dashboard.Page_Object_Dashboard;


	public class TestLeaveList extends Base_Class {

		@Test(priority = 0, enabled=true,description = "verify that leave list page loads successfully with no records")
		public void verifyLeaveListPageShowsNoRecords() throws InterruptedException {
			// **Arrange**: setup done in @beforeMethod
			dashboardPage.clickOnLeaveTab();
			
	        // **Act**: Perform action to load Leave List page
			String leavePageTitle = leaveListPage.leavePageLoaded();
	        String noRecordsMessage = leaveListPage.leaveListPageNoRecordMessage().trim();
	        
	     // **Assert**: Validate that no records are found
			Assert.assertEquals(leavePageTitle, "Leave","Leave page did not load sucessfully");
			Assert.assertEquals(noRecordsMessage, "No Records Found","No Records Found message not displayed!");

		}
		
		@Test(priority = 1, description = "verify that leave list page loads successfully with records")
		public void verifyLeaveListPageShowsRecords() throws InterruptedException {
			
			  // **Arrange**: Set up by applying a leave
			dashboardPage.clickOnLeaveTab();
			Assert.assertEquals(leaveListPage.leavePageLoaded(), "Leave","Leave page did not load successfully!");
			leaveListPage.clickOnApplyTab();
			Assert.assertEquals(applyLeavePage.applyleavePageLoaded(), "Apply Leave","Apply Leave page did not load!");
			
			//apply leave
			applyLeave();
			
	        // **Act**: Navigate back to Leave List and fetch records
			dashboardPage.clickOnLeaveTab();
			
	        // **Assert**: Verify that leave records are present
			Assert.assertTrue(leaveListPage.leaveListPageWithRecords(),"No one has applied the leave ");
			
		}
		
		

	}


