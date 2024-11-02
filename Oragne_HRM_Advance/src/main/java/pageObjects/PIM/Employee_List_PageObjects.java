package pageObjects.PIM;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base_Objects.Base_Objects;
public class Employee_List_PageObjects extends Base_Objects

//FINDING THE LOCATORS 

{

	private By Employee_List = By.xpath("//a[normalize-space()='Employee List']");
	private By Employee_List_Dropdown = By.xpath("//i[@class='oxd-icon bi-caret-up-fill']");	
	private By Employee_Name = By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--focus']//input[@placeholder='Type for hints...']");
	private By Employee_ID = By.xpath("//input[@class='oxd-input oxd-input--focus']");
	private By Employee_Status = By.xpath("//div[3]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
	private By Include = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");
	private By Supervisor_Name = By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--focus']//input[@placeholder='Type for hints...']");
	private By Job_Title = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");
	private By Sub_Unit = By.xpath("//div[@class='oxd-select-text oxd-select-text--focus']");
	private By Reset_Button = By.xpath("//button[@type='reset']");
	private By Search_Button = By.xpath("//button[@type='submit']");
	private By Add_Button = By.xpath("//button[normalize-space()='Add']");
	private By Select_All_ID = By.xpath("//div[@role='columnheader']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
	private By Edit = By.xpath("//div[@role='table']//div[1]//div[1]//div[9]//div[1]//button[1]//i[1]");
	private By Delete = By.xpath("//div[@role='table']//div[1]//div[1]//div[9]//div[1]//button[2]//i[1]");
	private By Pagination_Number = By.xpath("//button[normalize-space()='1']");
	private By Pagination_Arrow = By.xpath("//i[@class='oxd-icon bi-chevron-right']");
	
	
	
	//CREATING A RE-USABLE METHOD FOR THE EMPLOYEE LIST SECTION DROPDOWN
	
	public void Employee_Section_Drop()
	{
		WebElement Clk_Drop = wait.until(ExpectedConditions.elementToBeClickable(Employee_List_Dropdown));
		Clk_Drop.click();
	}
	
	//CREATE THE RE_USABLE METHODS FOR THE EMPLOYEE LIST BUTTON THE HEADER SECTION 
	
		public void Clk_Employee_Lst()
		{
			WebElement Clk_Emp_Lst = wait.until(ExpectedConditions.elementToBeClickable(Employee_List));
			Clk_Emp_Lst.click();
		}
		
	
	
	//CREATING RE-USABLE METHODS FOR EMPLOYEE NAME
	
	public void Clk_Employee_Name( String name )
	{
		WebElement Employee_Name_Element = wait.until(ExpectedConditions.elementToBeClickable(Employee_Name));
		Employee_Name_Element.clear();
		Employee_Name_Element.sendKeys(name);
	}
	
	
	//CREATING RE-USABLE METHOD FOR THE EMPLOYEE _ID 
	
	public void Clk_Employee_ID(String ID)
	{
		WebElement Clk_Emp_ID = wait.until(ExpectedConditions.elementToBeClickable(Employee_ID));
		Clk_Emp_ID.clear();
		Clk_Emp_ID.click();
		Clk_Emp_ID.sendKeys(ID);
		
	}
	
	//CREATING RE - USABLE METHODS FOR THE EMPLOYEE STATUS TO CLICK ON SPECIFIC OPTION (HARD CODE)
	
	public void Clk_Employee_Status(String Status)
	{
		try
		{
		//CLICK TO OPEN THE DROPDOWN
		
		WebElement Clk_Emp_St = wait.until(ExpectedConditions.elementToBeClickable(Employee_ID));
		Clk_Emp_St.click();
		
		//CONSTRUCT THE DYNAMIC XPATH TO FIND THE  STATUS OPTION
		By Status_Option = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[5]/span" + Status + "']");
		WebElement Options = wait.until(ExpectedConditions.elementToBeClickable(Status_Option));
		Options.click();
		
		Assert.assertTrue(Options.isDisplayed(),"Failed To Select The Status:"+Status);
		
		}catch(Exception e )
		{
			System.err.println("Error in selecting status: " + e.getMessage());
			throw e;
		}
	}
	
	
	//CREATING RE-USABLE METHODS THAT WILL RANDOMLY SELECT ONE OPTION FROM THE EMPLOYEE STATUS DROP DOWN 
	
	public void Rnd_Clk_Employee_Status()
	{
		try {
		
			WebElement Rnd_DropDown_Emp_St = wait.until(ExpectedConditions.elementToBeClickable(Employee_Status));
			Rnd_DropDown_Emp_St.click();			
			
			
			//FETCH ALL THE OPTIONS OF THE DROPDOWN IN THE LIST
			List<WebElement> options = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]"));
			
			
			//SELECTING A RANDOM OPTION
			
			Random random = new Random();
			int randomIndex  = random.nextInt(options.size());
			WebElement randomOptions = options.get(randomIndex);
			randomOptions.click();
			
			Assert.assertTrue(randomOptions.isDisplayed(),"Failed To Select options randomly ");
		
		}
		catch(Exception Rnd)
		
		{
			
			 System.err.println("Error in Selecting Option:"+ Rnd.getMessage());
		}
		
		
		
		
	}
	
	
	//CREATING A RE-USABLE METHOD TO SEELCT A SPECEFIC OPTION FORM THE INCLUDE DROPDOWN
	
			public void Select_Include()
			{
				WebElement slt_Include = wait.until(ExpectedConditions.elementToBeClickable(Include));
				slt_Include.click();
				
				
				
			}
	 
	
}




































