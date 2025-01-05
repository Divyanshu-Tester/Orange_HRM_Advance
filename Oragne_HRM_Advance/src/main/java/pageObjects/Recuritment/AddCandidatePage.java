package pageObjects.Recuritment;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import Utilities.BrowserUtilities;

public class AddCandidatePage extends BrowserUtilities {

	private WebDriver driver;

	public AddCandidatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// driver argument means that this driver will be used to lok yp elements and
		// second
		// argument is passed to tell pagefactory that this class weblements need to be
		// intiated

		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	WebElement firstName;

	@FindBy(name = "lastName")
	WebElement lastName;

	/*
	 * @FindBy(xpath="//label[text()='Email']") WebElement email;
	 */

	@FindBy(css = "button[type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//h6[text()='Add Candidate']")
	WebElement addCandidatePage;

	@FindBy(xpath = "(//p[contains(@class,'oxd-toast-content-text')])[2]")
	WebElement getSucessMessage;

	public String addCandidatePageLoaded() {
		waitElementToVisible(driver, 2, addCandidatePage);
		return addCandidatePage.getText();
	}

	public void addnewCandidate(String Name, String LastName, String Email) throws IOException {

		firstName.sendKeys(Name);
		lastName.sendKeys(LastName);
		// selenium 4 features
		driver.findElement(RelativeLocator.with(By.tagName("input"))
				.below(driver.findElement(By.xpath("//label[text()='Email']")))).sendKeys(Email);
		scrollPage(0, 600, driver);
		WebElement consent = driver.findElement(By.xpath("//label[text()='Consent to keep data']"));
		driver.findElement(RelativeLocator.with(By.tagName("i")).toLeftOf(consent)).click();
		getSingleElementScreenhsot(consent,Name);
		getHeightWidth(consent);
	}

	public void clickSubmit() {
		// scrollPage(0,600,driver);
		submitBtn.click();
	}

	public String getSucessMessage() {
		waitElementToVisible(driver, 10, getSucessMessage);
		return getSucessMessage.getText();
	}

}
