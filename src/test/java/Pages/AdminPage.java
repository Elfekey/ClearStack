package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.GeneralFunctions;

public class AdminPage  extends BasePage{
	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	GeneralFunctions gFunctions;
	//Varibles to be used 
	static int recsNo;
	static String employeeNameSelectedValue;
	String userNameString ="HussamElfekey";

	//Elements 
	@FindBy (xpath ="//span[@class='oxd-text oxd-text--span']") 
	public WebElement  recordsNo;

	@FindBy (xpath ="//i[@class='oxd-icon bi-plus oxd-button-icon']") 
	public WebElement  addNewUserBTN;

	//Fields to be filled elements 	
	@FindBy (xpath ="(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]") 
	public WebElement userRole;
	@FindBy (xpath ="(//div[@role='option'])[2]") 
	public WebElement userRoleValue;

	@FindBy (xpath ="//*/div/div[2]/div/div[2]/div/div/input") 
	public WebElement  employeeName;
	@FindBy (xpath ="(//div[@role='option'])[2]") 
	public WebElement  employeeNameFirstValue;

	@FindBy (xpath ="(//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]") 
	public WebElement  status;
	@FindBy (xpath ="(//div[@role='option'])[2]") 
	public WebElement statusValue;

	@FindBy (xpath ="(//input[@class='oxd-input oxd-input--active'])[2]") 
	public WebElement  username;

	@FindBy (xpath ="(//input[@type='password'])[1]") 
	public WebElement  password;

	@FindBy (xpath ="(//input[@type='password'])[2]") 
	public WebElement  confirmPassword;

	@FindBy (xpath ="//button[@type='submit']") 
	public WebElement  saveBTN;

	//Elements of Search and delete user
	@FindBy (xpath ="(//input[@class='oxd-input oxd-input--active'])[2]")
	public WebElement  UserNameSearch;
	//Elements of Search and delete user
		@FindBy (xpath ="//button[@type='submit']")
		public WebElement  SearchBTN;
		
	
	
	@FindBy (xpath ="(//i[@class='oxd-icon bi-trash'])[1]")
	public WebElement  trashIcon;
	
	@FindBy (xpath ="//i[@class='oxd-icon bi-trash oxd-button-icon']")
	public WebElement  trashIconClickYes;
	//Methods
	public void checkAdminPage() {
		gFunctions= new GeneralFunctions();
		gFunctions.CheckURL("admin");
	}

	public void getRecordsNo() {
		recsNo = gFunctions.ExtractNoOutOfString(recordsNo);
	}


	public void clickAddNewUser() {
		gFunctions.clickElement(addNewUserBTN);
	}
	public void fillNeededData() {
		gFunctions.clickElement(userRole);
		gFunctions.clickElement(userRoleValue);

		gFunctions.sendText(employeeName, "h");
//		employeeNameSelectedValue=gFunctions.getElementText(employeeNameFirstValue);
		gFunctions.clickElement(employeeNameFirstValue);

		gFunctions.clickElement(status);
		gFunctions.clickElement(statusValue);

		gFunctions.sendText(username, userNameString);
		gFunctions.sendText(password, "ClearStack123");
		gFunctions.sendText(confirmPassword, "ClearStack123");
	}
	public void clickSave() {
		gFunctions.clickElement(saveBTN);
	}

	public void getRecordsNoAfterAddAndAssertIncreasedByOne() {
		int  recsNoAfterAdd = gFunctions.ExtractNoOutOfString(recordsNo);
		Assert.assertTrue(recsNoAfterAdd==recsNo+1);
	}
	public void searchForUser() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gFunctions.sendText(UserNameSearch, userNameString);
		gFunctions.clickElement(SearchBTN);
	}
	public void deleteUSer() {
gFunctions.clickElement(trashIcon);
gFunctions.clickElement(trashIconClickYes);
	}
	
	public void getRecordsNoAfterDeleteAndAssertDecreasedByOne() {
		driver.navigate().refresh();
		int recsNoAfterDelete = gFunctions.ExtractNoOutOfString(recordsNo);
		Assert.assertTrue(recsNoAfterDelete==recsNo);
	}

}
