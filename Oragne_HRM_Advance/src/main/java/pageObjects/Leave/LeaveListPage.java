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
			waitElementToVisible(driver, 2, noRecordFoundMesz);

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
		waitForElementsVisible(driver, 2, totalLeaveListCount);
		if (totalLeaveListCount.size() > 0) {
			return true;
		}
		return false;
	}

}
