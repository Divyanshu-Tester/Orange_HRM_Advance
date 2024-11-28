package test_Cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base_Class.Base_Class;
import pageObjects.Leave.Apply;
//import pageObjects.Leave.Apply_Page_Objects;
//import pageObjects.Leave.Page_Objects_Leave;
import pageObjects.Login.Login_Page_Objects;

public class Dummy_Tests extends Base_Class


{

  @Test
  public void f() throws InterruptedException


  {
	  Login_Page_Objects Dummy = new Login_Page_Objects(driver);
	  //Page_Objects_Leave Dummy_Leave = new Page_Objects_Leave(driver);
	  //Apply_Page_Objects Dummy_Apply_Leave = new Apply_Page_Objects(driver);
	  Apply Dummy_Apply = new Apply(driver);


	  Dummy.Default_Username("Admin");
	  Dummy.dfltPassword("admin123");
	  Dummy.Click_Login();
	 // Dummy_Leave.Click_Leave_Button();
	  Thread.sleep(15000);
	  driver.findElement(By.xpath("//span[normalize-space()='Leave']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[normalize-space()='Apply']")).click();
	 Thread.sleep(5000);
	  Dummy_Apply.Select_Drop_Leave_Type(driver);
	  Dummy_Apply.select_From_Date(driver, null, null, null);
	  Thread.sleep(3000);
	  Dummy_Apply.select_TO_Date(driver, null, null, null);
	  Thread.sleep(5000);
	  Dummy_Apply.PartialDAys(driver);
	  Dummy_Apply.Add_Comments(driver, null);
	  Dummy_Apply.Click_Apply(driver);


  }


}
