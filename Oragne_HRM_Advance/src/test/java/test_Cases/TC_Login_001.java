package test_Cases;

import org.testng.annotations.Test;


import base_Class.Base_Class;
import base_Class.Configuration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import pageObjects.Login.Login_Page_Objects;

public class TC_Login_001 extends Base_Class //IMPORTING BASE CLASS TO LAUNCH THE DRIVER 




{
	WebDriver driver;
	 private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TC_Login_001.class);
	 JavascriptExecutor LoadTime = (JavascriptExecutor) driver;
	 
	  
  @Test
  public void Run_TC_Login_001() throws InterruptedException 
  
  {
	  
	  Configuration ttl = new Configuration();
	  ttl.getTitleLogin();
	  System.out.println("Log4j2 configuration file: " + System.getProperty("log4j.configurationFile"));
	  logger.info("Starting Test Case: TC_Login_001");
	  logger.debug("Login_Page_Objects initialized.");
	  
	  long startTime = (long)LoadTime.executeScript("return window.performance.timing.navigationStart;");
	  
	  long endTime = (long) LoadTime.executeScript("return window.performance.timning.endEvent;");
	  
	  long ldTime = endTime-startTime ;
	  
	  System.out.println("Page Load Time is "+ldTime +"millisecods");
	 
	  
	
	  
	// Initialize Logger
	   
	  //INITIALIZING LOGIN PAGE CLASS
	  Login_Page_Objects Login_Page = new Login_Page_Objects(driver);
      logger.debug("Login_Page_Objects initialized.");
	 
	  try {
		  
		  logger.info("Entering default username.");
          Login_Page.Default_Username("Admin");

          logger.info("Entering default password.");
          Login_Page.dfltPassword("admin123");

          logger.info("Clicking on the Login button.");
          Login_Page.Click_Login();

		  
	  }catch(Exception e)
	  {
		  logger.error("Error occurred in Test Case TC_Login_001: ", e);
          throw e;
	  }
	  
	  
	  
  }
}
