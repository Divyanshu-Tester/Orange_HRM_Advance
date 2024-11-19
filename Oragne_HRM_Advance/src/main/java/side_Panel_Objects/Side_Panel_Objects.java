package side_Panel_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base_Objects.Base_Objects;

public class Side_Panel_Objects extends Base_Objects


{
		

	// ASSIGNING LOCATORS 
	
	public Side_Panel_Objects(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By Click_Leave = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Leave']");
	
	public void clkLeave()
	{
		WebElement clickLeave = wait.until(ExpectedConditions.elementToBeClickable(Click_Leave));
		clickLeave.click();
	}
}
