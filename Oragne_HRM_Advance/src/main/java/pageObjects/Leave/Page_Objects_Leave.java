package pageObjects.Leave;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page_Objects_Leave

{

	public WebDriver driver;
	public WebDriverWait wait;

	public Page_Objects_Leave(WebDriver driver)
	{
		this.driver =driver;
		this.wait= new WebDriverWait(driver,Duration.ofSeconds(15));
	}

	private By Click_Leave = By.xpath("//a[@class='oxd-main-menu-item active']");


	public By Click_Leave_Button()
	{
		WebElement Wait_Leave = ((FluentWait<WebDriver>) wait).until(ExpectedConditions.visibilityOfElementLocated(Click_Leave_Button()));
		driver.findElement(Click_Leave).click();
		return Click_Leave;
	}
}
