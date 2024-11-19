package pageObjects.Leave;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base_Objects.Base_Objects;

public class Leave_List extends Base_Objects


{
	

	//ASSIGNING LOCATORS 
	
	public Leave_List(WebDriver driver) 
	
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}


	private By LL_From_Date = By.xpath("(//i[contains(@class, 'bi-calendar')])[1]");
	private By LL_To_Date = By.xpath("//input[@placeholder='To Date']/following-sibling::i[contains(@class, 'oxd-icon') and contains(@class, 'bi-calendar')]");
    private By LL_Show_Leave_Status = By.xpath("//i[contains(@class, 'oxd-icon') and contains(@class, 'bi-caret-down-fill') and contains(@class, 'oxd-select-text--arrow')]");
    private By LL_Leave_Type = By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
    private By LL_Employee_Name = By.xpath("//input[@placeholder='Type for hints...']");
    private By LL_Sub_Unit = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");
    
   
    public void sltSpfFrmDT()
    
    {
    	try
    	{
    		
    	
    	WebElement clkDate = wait.until(ExpectedConditions.elementToBeClickable(LL_From_Date));
    	clkDate.click();
    	
    	
    	//Clicking On the Year List
    	By clkYear = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/ul/li[2]/div/i");
    	
    	
    	}
    	catch(Exception FrDate)
    	{
    		
    	}
    }
	
	
}


