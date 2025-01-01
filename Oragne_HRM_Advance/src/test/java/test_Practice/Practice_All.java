package test_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import base_Class.Base_Class;
import base_Class.Configuration;
import pageObjects.Dashboard.Page_Object_Dashboard;
import pageObjects.Login.Login_Page_Objects;
import pageObjects.PIM.Employee_List_PageObjects;

public class Practice_All extends Base_Class 

{
	

    @Test
    public void f() throws InterruptedException
    
    
 {
        
      Login_Page_Objects user = new Login_Page_Objects(driver);
        user.Default_Username("Admin");
        
        Configuration chkURL = new  Configuration();
        chkURL.brknLink();
        
        
        Page_Object_Dashboard PIM = new Page_Object_Dashboard(driver);
        PIM.clickPIM();
        
        Employee_List_PageObjects EmpSt = new Employee_List_PageObjects(driver);
        EmpSt.Clk_Employee_Status(null);
        
        
     
       
    }
}
