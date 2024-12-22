package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {
	
	public WebDriver driver;
	static String selectedmonth ;
	public BrowserUtilities(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public static void staticWait(int sleepTimeInSeconds) {
		try {
			Thread.sleep(sleepTimeInSeconds * 1000L);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void waitElementToVisible(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	
	public void waitElementToVisible(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	
	}
	
	public void waitForInvisibility(WebDriver driver,int time, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	wait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}
	
	public void waitElementToBeClickable(WebDriver driver, int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//reusable selelctdate function
	public  void selectDateFromCalendar(String month,WebDriver driver,WebElement calendarField, List<WebElement> listOfDays, String day,WebElement selectedMonth,WebElement chooseMonth) {
		waitElementToVisible(driver,1,calendarField);
		calendarField.click();
		
		waitForElementsVisible(driver,2,listOfDays);
		 selectedmonth=selectedMonth.getText();
		System.out.println(selectedmonth);
		while(!(selectedMonth.getText().equals(month))) {
			chooseMonth.click();
		}
    	System.out.println(listOfDays.size());
    	for(int i=0;i<listOfDays.size();i++) {
    		String calendarDay=listOfDays.get(i).getText();
    		try {
    		if(calendarDay.equals(day)) {
    			listOfDays.get(i).click();
    			break;
    		}
    	}
    	catch(Exception e) {
    		System.out.println(e.getStackTrace());
    	}}
	}

	public  void  waitForElementsVisible(WebDriver driver, int timeout, List<WebElement> locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		 wait.until(ExpectedConditions.visibilityOfAllElements(locator));
		 
	
	}

	public void scrollPage(int x, int y, WebDriver driver) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}
	
	public void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
	        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
	    );
	}
}
