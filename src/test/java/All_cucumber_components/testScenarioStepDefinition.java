package All_cucumber_components;

import org.openqa.selenium.chrome.ChromeDriver;
import Pages.AdminPage;
import Pages.DashBoardPage;
import Pages.HomePage;
import Utilities.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class testScenarioStepDefinition  extends BaseTest{ 
	//objects
	HomePage homePage;	
	DashBoardPage dBoardPage;
	AdminPage adminPage;

	//FirstPart: Login with valid credentials
	//Login part 
	@Given("User should be able to login using valid credintials {string}")
	public void GoToWebSite(String url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		homePage = new HomePage(driver);
		driver.get(url);
	}
	@When("User enters username as {string} and password as {string}")
	public void EnterCredintials(String userName, String passWord) {
		homePage.enterCredentials(userName, passWord);
	}
	@And ("click login")
	//	@Then("User should be able to login sucessfully and new page open")
	public void clickLogIn() {
		homePage.clickLogIn();
	}
	@Then("User should be able to see dashoboard")
	public void checkLoginSuccessfully() {
		dBoardPage = new DashBoardPage(driver);
		dBoardPage.checkDashBoardPage();
	}
	//End of Login part 

	//Second Part: Go to admin page and add user
	@Given("User should be able to see the records number")
	public void goToAdminPageAndCheckRecordNumber() {
		adminPage = new AdminPage(driver);
		dBoardPage = new DashBoardPage(driver);
		dBoardPage.goToAdminPage();
		adminPage.checkAdminPage();
		adminPage.getRecordsNo();
	}
	@When("User click add button")
	public void UserClickAddButton( ) {
		adminPage.clickAddNewUser();
	}
	@And ("Fill the required data and click save")
	public void FillTheRequiredDataAndClickSave() {
		adminPage.fillNeededData();
		adminPage.clickSave();
	}
	@Then("Verify that the number of records increased by one")
	public void VerifyThatTheNumberOfRecordsIncreasedByOne() {
		adminPage.getRecordsNoAfterAddAndAssertIncreasedByOne();
	}
	//End of Go to admin page and add user

	//Third   Part: Search and delete user
	@Given("User should be able to search for users")
	public void UserShouldBeAbleToSearchForUsers() { 
		adminPage.searchForUser();
	}
	@When ("Delet user")
	public void DeleteUser() {
		adminPage.deleteUSer();	
	}
	@Then("Verify that the number of records decreased by one")
	public void VerifyThatTheNumberOfRecordsDecreasedByOne() {
		adminPage.getRecordsNoAfterDeleteAndAssertDecreasedByOne();
	}
	//end of Search and delete user



}
