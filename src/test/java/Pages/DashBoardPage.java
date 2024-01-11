package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.GeneralFunctions;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
GeneralFunctions gFunctions;
	
	
	
	//Elements 
	@FindBy (xpath ="(//span[contains(@class,'oxd-text oxd-text--span ox')])[1]") 
	public WebElement  adminBTN;

	
	//Methods
	public void checkDashBoardPage() {
		gFunctions= new GeneralFunctions();
		gFunctions.CheckURL("dashboard");
	}
	
	public void goToAdminPage() {
		gFunctions= new GeneralFunctions();
		gFunctions.clickElement(adminBTN);
	}
}
