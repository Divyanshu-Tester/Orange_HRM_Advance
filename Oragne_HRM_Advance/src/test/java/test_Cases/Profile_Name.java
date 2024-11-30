package test_Cases;

import org.testng.annotations.Test;

import base_Class.Base_Class;
import pageObjects.Login.Login_Page_Objects;
import pageObjects.Profile.Dynamic_Profile;

public class Profile_Name extends Base_Class


{
  @Test
  public void f() 
  
  {
	  Login_Page_Objects Login = new Login_Page_Objects(driver);
	  Login.Default_Username("admin");
	  Login.Default_Password("admin123");
	  Login.Click_Login();
	  Dynamic_Profile Name = new  Dynamic_Profile(driver);
	 
	  String UserName = Name.usrName();
	  System.out.println("The user name is: " + UserName);
  }

}
