package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {
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

	public List<WebElement> waitForElementsVisible(WebDriver driver, int timeout, List<WebElement> locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}

	public void scrollPage(int x, int y, WebDriver driver) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}
}
