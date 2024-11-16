package pageObjects.Leave;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.BrowserUtilities;

public class LeaveListPage extends BrowserUtilities {

	public WebDriver driver;

	public LeaveListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		// driver argument means that this driver will be used to lok yp elements and
		// second
		// argument is passed to tell pagefactory that this class weblements need to be
		// intiated

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h6[contains(@class,'breadcrumb-module')]")
	WebElement leave;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast-content--info')]/p[2]")
	WebElement noRecordFoundMesz;

	@FindBy(xpath = "//div[@class='oxd-table-body']/div")
	List<WebElement> leaveList;

	@FindBy(xpath = "//div[@class='oxd-table-header']//span[contains(@class,'oxd-checkbox-input--active')]")
	WebElement bulkDeleteCheckbox;

	@FindBy(xpath = "//button[contains(@class,'oxd-button--label-warn')]")
	WebElement clickOnCancelBtn;

	@FindBy(xpath = "//div[@class='orangehrm-modal-footer']/button[2]")
	WebElement clickConfirmationCancelBtn;

	@FindBy(css = "nav[class='oxd-topbar-body-nav'] ul li:nth-child(1)")
	WebElement applyLeaveTab;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]")
	List<WebElement> totalLeaveListCount;

	@FindBy(xpath = "(//div[@class='oxd-date-input']/input)[1]")
	WebElement clickOnStartDateField;

	@FindBy(xpath = "(//div[@class='oxd-date-input']/input)[2]")
	WebElement clickOnEndDateField;

	@FindBy(xpath = "//div[@class='oxd-calendar-date']")
	List<WebElement> listOfAllDays;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[@class='oxd-calendar-selector-month-selected']/p")
	WebElement getSelectedMonth;
	
	@FindBy(xpath="//button[@class='oxd-icon-button'] //i[contains(@class,'bi-chevron-right')]")
	WebElement chooseNextMonth;
	
	@FindBy(xpath="//button[@class='oxd-icon-button'] //i[contains(@class,'bi-chevron-left')]")
	WebElement choosePreviousMonth;
	
	@FindBy(xpath="//button[contains(@class,'oxd-button--ghost')]")
	WebElement resetFilterBtn;
	
	
	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[2]")
	List<WebElement> leaveRecordCount;
	
	@FindBy(xpath="//span[contains(@class,'oxd-multiselect-chips-selected')]")
	WebElement leaveStatusValue;


	public String leavePageLoaded() {
		waitElementToVisible(driver, 2, leave);
		return leave.getText();
	}

	public void bulkDeleteOperation() {
		bulkDeleteCheckbox.click();
		clickOnCancelBtn.click();
		staticWait(1);
		clickConfirmationCancelBtn.click();
	}

	public String leaveListPageNoRecordMessage() {
		staticWait(1);
		System.out.println("the size of the leave list is " + leaveList.size());
		if (leaveList.size() == 0) {
			waitElementToVisible(driver, 3, noRecordFoundMesz);

			return noRecordFoundMesz.getText();
		} else {

			bulkDeleteOperation();
			waitElementToVisible(driver, 2, noRecordFoundMesz);

			return noRecordFoundMesz.getText();
		}
	}

	public void clickOnApplyTab() {
		staticWait(2);
		applyLeaveTab.click();
	}

	public boolean leaveListPageWithRecords() throws InterruptedException {
		try {
		waitForElementsVisible(driver, 2, totalLeaveListCount);
		return totalLeaveListCount.size() > 0;
		
		}catch(Exception e) {
			System.out.println("Error in leaveListPageWithRecords: " + e.getMessage());
		return false;
		}
	}

	public void selectFromDate(String day,String month) {
		BrowserUtilities.selectDateFromCalendar(month ,driver,clickOnStartDateField, listOfAllDays, day,getSelectedMonth,chooseNextMonth);

	}

	public void selectToDate(String day,String month) {
		BrowserUtilities.selectDateFromCalendar(month,driver,clickOnEndDateField, listOfAllDays, day,getSelectedMonth,choosePreviousMonth);

	}

	public void applyDateFilter(String fromDate, String toDate,String month) {
		selectFromDate(fromDate,month);
		selectToDate(toDate,month);
		scrollPage(0,400,driver);
		searchBtn.click();
	}
	
	public void clickResetFilterButton() {
		resetFilterBtn.click();
	}
	
	public List<WebElement> getLeaveRecords() {
		return leaveRecordCount;
	}
	
	public String getSelectedLeaveStatus() {
	return	leaveStatusValue.getText();
	}
	
}
