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
	// "//div[@class='oxd-table-card']
	// //div[contains(@class,'oxd-table-row--with-border')]")
	List<WebElement> totalLeaveListCount;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[7]")
	// "//div[@class='oxd-table-card']
	// //div[contains(@class,'oxd-table-row--with-border')]")
	List<WebElement> totalLeavesWithStatus;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[4]")
	// "//div[@class='oxd-table-card']
	// //div[contains(@class,'oxd-table-row--with-border')]")
	List<WebElement> totalLeavesWithLeaveType;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[3]")
	List<WebElement> totalLeavesWithEmpyName;

	@FindBy(xpath = "(//div[@class='oxd-date-input']/input)[1]")
	WebElement clickOnStartDateField;

	@FindBy(xpath = "(//div[@class='oxd-date-input']/input)[2]")
	WebElement clickOnEndDateField;

	@FindBy(xpath = "//div[@class='oxd-calendar-date']")
	List<WebElement> listOfAllDays;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='oxd-calendar-selector-month-selected']/p")
	WebElement getSelectedMonth;

	@FindBy(xpath = "//button[@class='oxd-icon-button'] //i[contains(@class,'bi-chevron-right')]")
	WebElement chooseNextMonth;

	@FindBy(xpath = "//button[@class='oxd-icon-button'] //i[contains(@class,'bi-chevron-left')]")
	WebElement choosePreviousMonth;

	@FindBy(xpath = "//button[contains(@class,'oxd-button--ghost')]")
	WebElement resetFilterBtn;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[2]")
	public List<WebElement> leaveRecordCount;

	@FindBy(xpath = "//span[contains(@class,'oxd-multiselect-chips-selected')]")
	WebElement leaveStatusValue;

	@FindBy(css = "i[class*='bi-x --clear']")
	WebElement removeDefaultLeaveStatus;

	@FindBy(xpath = "//div[contains(@class,'oxd-select-text--error')]")
	WebElement clickOnDropdownIcon;

	@FindBy(xpath = "//div[@class='oxd-select-option']/span")
	List<WebElement> getListOfAllStatus;

	@FindBy(xpath = ("(//div[contains(@class,'oxd-select-text--active')])[2]"))
	WebElement clickSelectLeaveType;

	// @FindBy(xpath="//div[contains(@class,'oxd-autocomplete-text-input--active')]")
	// WebElement clickOnEmpField;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']/div/input")
	WebElement clickOnEmpField;

	@FindBy(xpath = "//div[@class='oxd-table-cell-actions']/li/button/i")
	WebElement actionMenuOption;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[1]/p")
	WebElement addComment;

	@FindBy(css = "textarea[class*='oxd-textarea']")
	WebElement commentHere;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveComment;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[2]/p")
	WebElement viewLeaveDetails;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[3]/p")
	WebElement viewPimInfo;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[4]/p")
	WebElement cancelLeave;

	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']/span")
	List<WebElement> EmploysList;

	@FindBy(xpath = "(//p[contains(@class,'oxd-toast-content-text')])[2]")
	WebElement getSucessMessage;

	@FindBy(xpath = "//h6[contains(@class,'oxd-text--h6 orangehrm-main-title')]")
	WebElement listDetails;

	@FindBy(xpath = "(//p[contains(@class,'orangehrm-request-details-text')])[1]")
	WebElement employeName;

	@FindBy(xpath = "(//p[contains(@class,'orangehrm-request-details-text')])[2]")
	WebElement leavedate;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[2]")
	WebElement leaveType;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[5]")
	WebElement leaveStatusRequestDetails;

	@FindBy(xpath = "//div[@class='oxd-table-card'] //div[contains(@class,'oxd-table-row--with-border')]/div[6]")
	WebElement getComment;

	@FindBy(xpath = "//button[normalize-space()='Comments']")
	WebElement comments;

	@FindBy(xpath = "//button[normalize-space()='Back']")
	WebElement back;

	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li[2]/p")
	WebElement cancelLeaveRequestDetails;

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

		} catch (Exception e) {
			System.out.println("Error in leaveListPageWithRecords: " + e.getMessage());
			return false;
		}
	}

	public void selectFromDate(String day, String month) {
		selectDateFromCalendar(month, driver, clickOnStartDateField, listOfAllDays, day, getSelectedMonth,
				chooseNextMonth);

	}

	public void selectToDate(String day, String month) {
		selectDateFromCalendar(month, driver, clickOnEndDateField, listOfAllDays, day, getSelectedMonth,
				choosePreviousMonth);

	}

	public void applyDateFilter(String fromDate, String toDate, String month) {
		selectFromDate(fromDate, month);
		selectToDate(toDate, month);
		// scrollPage(0,400,driver);

	}

	public void clickResetFilterButton() {
		resetFilterBtn.click();
	}

	public List<WebElement> getLeaveRecords() {
		try {
			if(leaveRecordCount.size()!=0) {
			waitForElementsVisible(driver, 2, leaveRecordCount);}
			return leaveRecordCount;
		} catch (TimeoutException e) {
			return new ArrayList<>();
		}
	}

	public String getSelectedLeaveStatus() {
		return leaveStatusValue.getText();
	}

	public boolean verifyAllRecordsWithLeaveStatus(String leaveStatus) {
		boolean allRecord = true;
		try {
			waitForElementsVisible(driver, 2, totalLeavesWithStatus);
			for (WebElement status : totalLeavesWithStatus) {
				System.out.println(status.getText());
				if (!status.getText().contains(leaveStatus)) {
					allRecord = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return allRecord;
	}

	public void clearDefaultLeaveStatusOption() {
		// TODO Auto-generated method stub
		waitElementToBeClickable(driver, 2, removeDefaultLeaveStatus);
		removeDefaultLeaveStatus.click();
	}

	public void chooseLeaveStatusFromList(String leaveStatus) {
		// TODO Auto-generated method stub
		clickOnDropdownIcon.click();
		waitForElementsVisible(driver, 2, getListOfAllStatus);
		for (WebElement status : getListOfAllStatus) {
			if (status.getText().equals(leaveStatus)) {
				status.click();
				break;
			}
		}
	}

	public void clickSearchButton() {
		scrollPage(0, 300, driver);
		searchBtn.click();
	}

	public void selectLeaveType(String leaveType) {
		// TODO Auto-generated method stub
		clickSelectLeaveType.click();
		waitForElementsVisible(driver, 2, getListOfAllStatus);
		for (WebElement status : getListOfAllStatus) {
			if (status.getText().equals(leaveType)) {
				status.click();
				break;
			}
		}

	}

	public boolean verifyAllRecordsWithLeaveType(String leaveStatus) {
		// TODO Auto-generated method stub
		boolean allRecord = true;
		try {
			waitForElementsVisible(driver, 2, totalLeavesWithLeaveType);
			for (WebElement status : totalLeavesWithLeaveType) {
				System.out.println(status.getText());
				if (!status.getText().contains(leaveStatus)) {
					allRecord = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return allRecord;
	}

	public void searchWithEmployeeName(String empName) {
		clickOnEmpField.click();
		System.out.println("empyname" + empName);
		clickOnEmpField.sendKeys(empName);
		waitForElementsVisible(driver, 2, EmploysList);
		System.out.println("size of emply" + EmploysList.size());

		WebElement targetElement = EmploysList.stream().peek(e -> System.out.println("Element found: " + e.getText()))
				.filter(s -> s.getText().contains(empName))
				.peek(e -> System.out.println("Filtered element text: " + e.getText())).findAny()
				.orElseThrow(() -> new NoSuchElementException("No element found with name: " + empName));
		targetElement.click();
	}

	public boolean verifyAllRecordsWithEmployName(String empyName) {
		// TODO Auto-generated method stub
		boolean allRecord = true;
		try {
			waitForElementsVisible(driver, 2, totalLeavesWithEmpyName);
			for (WebElement status : totalLeavesWithEmpyName) {
				System.out.println(status.getText());
				if (!status.getText().contains(empyName)) {
					allRecord = false;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return allRecord;
	}

	// Add Commnet Section
	public void clickMoreOptionBtn() {
		waitElementToVisible(driver, 2, actionMenuOption);
		scrollPage(0, 400, driver);
		actionMenuOption.click();
	}

	public void clickAddCommentBtn() {
		waitElementToVisible(driver, 2, addComment);
		addComment.click();
	}

	public void addCommnet(String comment) {
		commentHere.sendKeys(comment);
	}

	public void submitComment() {
		waitElementToVisible(driver, 10, saveComment);
		waitElementToBeClickable(driver, 6, saveComment);
		saveComment.click();
	}

	public String getSucessMessage() {
		waitElementToVisible(driver, 3, getSucessMessage);
		return getSucessMessage.getText();
	}

	public void clickViewDetailsOption() {
		waitElementToBeClickable(driver, 2, viewLeaveDetails);
		viewLeaveDetails.click();
	}

	// REQUEST DETAILS PGE
	public String verifyLeaveRequestDetailsLoads() {
		try {
			waitElementToVisible(driver, 2, listDetails);
			System.out.println(listDetails.getText());
			return listDetails.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;

		}
	}

	public String getEmployeName() {
		try {
			waitElementToVisible(driver, 2, employeName);
			return employeName.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getLeaveDate() {
		try {
			waitElementToVisible(driver, 2, leavedate);
			return leavedate.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;

		}
	}

	public String getLeaveType() {
		try {
			waitElementToVisible(driver, 2, leaveType);
			return leaveType.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;

		}
	}

	public String getComment() {
		try {
			waitElementToVisible(driver, 2, getComment);
			return getComment.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void getCommentsBtn() {
		comments.click();
	}

	

	public void cancelLeave() {
	waitElementToVisible(driver,2,leaveStatusRequestDetails);
		if (leaveStatusRequestDetails.getText() != "Cancelled") {
			waitElementToBeClickable(driver,2,cancelLeaveRequestDetails);
			cancelLeaveRequestDetails.click();
		}
	}

	public String getLeaveStatusOnRequestDetails() {
		try {
			waitElementToVisible(driver,2,leaveStatusRequestDetails);
			return leaveStatusRequestDetails.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void getBackBtn() {
		back.click();
	}

}