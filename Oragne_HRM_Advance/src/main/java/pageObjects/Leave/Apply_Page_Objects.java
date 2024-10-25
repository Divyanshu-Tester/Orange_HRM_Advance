package pageObjects.Leave;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;  //  THIS CLASS IS FOR THE LEAVE PAGE OBJECTS NOR FOR THE APPLY PAGE OBJECTS <THE PAGE OBJECTS OF APPLY WILL BE
                                                      // FOUNDED IN [APPLY PACKAGE]

public class Apply_Page_Objects 


{
	WebDriver driver;
	WebDriverWait wait;
	//WebDriver dropdown;
	
	public Apply_Page_Objects(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	}
	
	
	// LOCATING ELEMENTS
	
	private By LL_From_Date = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//i[1]");
	private By LL_To_Date = By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div[1]/div[2]/div[1]/div[1]/i[1]");
    private By LL_Show_Leave_Status = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");
    private By LL_Leave_Type = By.xpath("//div[4]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
    private By LL_Employee_Name = By.xpath("//input[@placeholder='Type for hints...']");
    private By LL_Sub_Unit = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");
    
    //CREATING RE-USABLE METHODS
    
    public void Select_Drop_From_Date(WebDriver driver)
    {
    	
    	driver.findElement(LL_From_Date);
    	Select dropdown=new Select(null);
    	dropdown.selectByIndex(1);
    
    	
    }
}





















