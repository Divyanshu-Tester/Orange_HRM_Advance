package pageObjects.Leave;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Apply


{

	WebDriver driver;
	WebDriverWait wait ;
	FluentWait<WebDriver> fluentWait;

	public Apply(WebDriver driver)

	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));

		this.fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

	}

	private By Leave_Type =By.xpath("//div[@class='oxd-select-text-input']");
	private By AL_From_Date = By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//i[1]");
	private By AL_To_Date = By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div[1]/div[2]/div[1]/div[1]/i[1]");
	private By Partial_Days = By.xpath("//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']");
	private By AL_Input_Comment = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[1]/div[1]/div[2]/textarea[1]");
	private By AL_Login_Button = By.xpath("//button[@type='submit']");


	// REUSABLE METHOD TO SELCT THE LEAVE TYPE
	public  void Select_Drop_Leave_Type(WebDriver driver) throws InterruptedException

	{
		try{

		WebElement LeaveDropdown= driver.findElement(Leave_Type);
		LeaveDropdown.click();
		WebElement First_Option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")));
		First_Option.click();
		((JavascriptExecutor) driver).executeScript("arguments[1].click();", First_Option);

	}catch (Exception e) {
        System.err.println("Exception occurred: " + e.getMessage());
    }

	}

	public void PartialDAys(WebDriver driver) throws InterruptedException
	{
		try {
			driver.findElement(Partial_Days).click();
			WebElement Select_Option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/div/div[2]/div[3]")));
			Select_Option.click();
			((JavascriptExecutor) driver).executeScript("arguments[1].click();", Select_Option);

		}catch(Exception Call_Exception2){
			System.err.println("Exception occured:" +Call_Exception2.getMessage());

		}

	}



	//RE-USABLE METHOD TO SELECT THE FROM DATE HARD CODE { REASON BEACUSE LEAVE IS ONLY FEW DAYS }


	public void select_From_Date(WebDriver driver , String expectedYear , String expectedMonth , String expectedDay)

	{
		WebElement Click_Calendar = driver.findElement(AL_From_Date);
		Click_Calendar.click();
		WebElement Month_Select = driver.findElement(By.xpath("//p[normalize-space()='October']"));
		Month_Select.click();
		WebElement Calendar_Month_Select_FD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-dropdown--option --selected']")));
		Calendar_Month_Select_FD.click();

		WebElement Calendar_Year_Select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-selector-year']//p[1]")));
		Calendar_Year_Select.click();

		WebElement Select_Year = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-dropdown--option --selected']")));
		Select_Year.click();

		WebElement Final_Date_Select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'28')]")));
		Final_Date_Select.click();
	}


	//RE-USABLE METHOD TO SELECT THE TO DATE


	public void select_TO_Date(WebDriver driver , String expectedYear , String expectedMonth , String expectedDay)

	{
		WebElement TO_Click_Calendar = driver.findElement(AL_To_Date);
		TO_Click_Calendar.click();

		WebElement TO_Month_Select = driver.findElement(By.xpath("//p[normalize-space()='October']"));
		TO_Month_Select.click();

		WebElement TO_Calendar_Month_Select_FD = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-dropdown--option --selected']")));
		TO_Calendar_Month_Select_FD.click();

		WebElement TO_Calendar_Year_Select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-selector-year']//p[1]")));
		TO_Calendar_Year_Select.click();

		WebElement TO_Select_Year = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-dropdown--option --selected']")));
		TO_Select_Year.click();

		WebElement TO_Final_Date_Select = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'30')]")));
		TO_Final_Date_Select.click();
	}




	public void Add_Comments(WebDriver driver , String Comment)
	{

		//textarea[@class='oxd-textarea oxd-textarea--focus oxd-textarea--resize-vertical']

		WebElement Click_Comment = driver.findElement(AL_Input_Comment);
		Click_Comment.click();
		Click_Comment.sendKeys("This is Divyanshu Testing");
	}

	public void Click_Apply(WebDriver driver )
	{
		WebElement Clk_Apply = driver.findElement(By.xpath("//button[@type='submit']"));
		Clk_Apply.click();
	}
}










