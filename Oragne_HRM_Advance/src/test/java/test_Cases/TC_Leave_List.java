package test_Cases;

import org.testng.annotations.Test;

import base_Class.Base_Class;
import pageObjects.Leave.Leave_List;
import pageObjects.Login.Login_Page_Objects;
import side_Panel_Objects.Side_Panel_Objects;

public class TC_Leave_List extends Base_Class

{
  @Test
  public void f() throws InterruptedException 
  
  {
	  Login_Page_Objects Login = new Login_Page_Objects(driver);
	  Login.Default_Username("admin");
	  Login.dfltPassword("admin123");
	  Login.Click_Login();
	  Thread.sleep(5000);
	  Side_Panel_Objects Leave = new Side_Panel_Objects(driver);
	  Leave.clkLeave();
	  Leave_List clkFromDate = new Leave_List(driver);
	  clkFromDate.sltSpfFrmDT();
	  
	  
  }
}
