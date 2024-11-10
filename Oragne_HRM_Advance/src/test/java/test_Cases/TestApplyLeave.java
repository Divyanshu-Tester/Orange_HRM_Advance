package test_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Utilities.ConfigReader;
import base_Class.Base_Class;
import pageObjects.Dashboard.Page_Object_Dashboard;

public class TestApplyLeave extends Base_Class {
	@Test(priority = 0)
	public void applyLeaveWithMandatoryFields() throws InterruptedException {
		loginPage.loadLoginPage();
		loginPage.Default_Username(ConfigReader.getConfigPropertyData("username"));
		loginPage.Default_Passowrd(ConfigReader.getConfigPropertyData("password"));
		Page_Object_Dashboard dashboardPage = loginPage.Click_Login();
		Assert.assertEquals(dashboardPage.dashboardLoaded(), "Dashboard");
		dashboardPage.clickOnLeaveTab();
		leaveListPage.clickOnApplyTab();
		System.out.println(applyLeavePage.applyleavePageLoaded());
		Assert.assertEquals(applyLeavePage.applyleavePageLoaded(), "Apply Leave");
		applyLeave();

	}

}
