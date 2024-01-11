package Pages;

import org.bouncycastle.mime.MimeWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.BaseTest;
import Utilities.GeneralFunctions;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	GeneralFunctions gFunctions;

	//Elements 
	@FindBy (xpath ="(//input[@placeholder])[1]")////input[@placeholder='Username']
	public WebElement  userNameElement;
	@FindBy (xpath ="(//input[@placeholder])[2]")
	public WebElement  userPasswordElement;
	@FindBy (xpath ="//button[@type=\"submit\"]")
	public WebElement  loginBTN;


	//Methods
	public void enterCredentials(String UserName,String UserPassword) {
		gFunctions= new GeneralFunctions();
		gFunctions.sendText(userNameElement, UserName);
		gFunctions.sendText(userPasswordElement, UserPassword);
	}

	public void clickLogIn() {
		gFunctions.clickElement(loginBTN);	
	}





}
