package pageObjects.Leave;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.TimeoutException;
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

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[2]")
			//"//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]")
	List<WebElement> totalLeaveListCount;
	
	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[7]")
	//"//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]")
List<WebElement> totalLeavesWithStatus;
	
	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[4]")
	//"//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]")
List<WebElement> totalLeavesWithLeaveType;

	
	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[3]")
	List<WebElement> totalLeavesWithEmpyName;
	
	
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
	
	@FindBy(css="i[class*='bi-x --clear']")
	WebElement removeDefaultLeaveStatus;
	
	@FindBy(xpath="//div[contains(@class,'oxd-select-text--error')]")
	WebElement clickOnDropdownIcon;
	
	@FindBy(xpath="//div[@class='oxd-select-option']/span")
	List<WebElement> getListOfAllStatus;
	
	@FindBy(xpath=("(//div[contains(@class,'oxd-select-text--active')])[2]"))
	WebElement clickSelectLeaveType;
	
	//@FindBy(xpath="//div[contains(@class,'oxd-autocomplete-text-input--active')]")
	//WebElement clickOnEmpField;
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-wrapper']/div/input")
	WebElement clickOnEmpField;
	
	
	@FindBy(xpath="//div[@class='oxd-autocomplete-option']/span")
	List<WebElement> EmploysList;


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
		//scrollPage(0,400,driver);
		
	}
	
	public void clickResetFilterButton() {
		resetFilterBtn.click();
	}
	
	public List<WebElement> getLeaveRecords() {
		try {
		waitForElementsVisible(driver,2,leaveRecordCount);
		return leaveRecordCount;
		}catch(TimeoutException e) {
			return new ArrayList<>();
		}
	}
	
	public String getSelectedLeaveStatus() {
	return	leaveStatusValue.getText();
	}
	
	public boolean verifyAllRecordsWithLeaveStatus(String leaveStatus) {
		boolean allRecord=true;
		try {
			waitForElementsVisible(driver,2,totalLeavesWithStatus);
		for(WebElement status:totalLeavesWithStatus) {
			System.out.println(status.getText());
			if(!status.getText().contains(leaveStatus)) {
				allRecord=false;
				break;
			}
		}}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return allRecord;
	}

	public  void clearDefaultLeaveStatusOption() {
		// TODO Auto-generated method stub
		waitElementToBeClickable(driver,2,removeDefaultLeaveStatus);
		removeDefaultLeaveStatus.click();
	}

	public void chooseLeaveStatusFromList(String leaveStatus) {
		// TODO Auto-generated method stub
		clickOnDropdownIcon.click();
		waitForElementsVisible(driver,2,getListOfAllStatus);
		for(WebElement status:getListOfAllStatus) {
			if(status.getText().equals(leaveStatus)) {
				status.click();
				break;
			}
		}
	}
	
	public void clickSearchButton() {
		scrollPage(0,300,driver);
		searchBtn.click();
	}

	public void selectLeaveType(String leaveType) {
		// TODO Auto-generated method stub
		clickSelectLeaveType.click();
		waitForElementsVisible(driver,2,getListOfAllStatus);
		for(WebElement status:getListOfAllStatus) {
			if(status.getText().equals(leaveType)) {
				status.click();
				break;
			}
		}
		
	}

	public boolean verifyAllRecordsWithLeaveType(String leaveStatus) {
		// TODO Auto-generated method stub
		boolean allRecord=true;
		try {
			waitForElementsVisible(driver,2,totalLeavesWithLeaveType);
		for(WebElement status:totalLeavesWithLeaveType) {
			System.out.println(status.getText());
			if(!status.getText().contains(leaveStatus)) {
				allRecord=false;
				break;
			}
		}}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return allRecord;
	}
	
	public void searchWithEmployeeName(String empName) {
		clickOnEmpField.click();
		System.out.println("empyname"+empName);
		clickOnEmpField.sendKeys(empName);
		waitForElementsVisible(driver,2,EmploysList);
		System.out.println("size of emply"+EmploysList.size());

		WebElement targetElement=	EmploysList.stream().peek(e -> System.out.println("Element found: " + e.getText())).
				filter(s->s.getText().contains(empName)).peek(e -> System.out.println("Filtered element text: " + e.getText()))
				.findAny()
				.orElseThrow(() -> new NoSuchElementException("No element found with name: " + empName));
		targetElement.click();
	}

	public boolean verifyAllRecordsWithEmployName(String empyName) {
		// TODO Auto-generated method stub
		boolean allRecord=true;
		try {
			waitForElementsVisible(driver,2,totalLeavesWithEmpyName);
		for(WebElement status:totalLeavesWithEmpyName) {
			System.out.println(status.getText());
			if(!status.getText().contains(empyName)) {
				allRecord=false;
				break;
			}
		}}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return allRecord;
	}
	
}
