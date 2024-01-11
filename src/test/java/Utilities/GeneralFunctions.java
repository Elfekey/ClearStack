package Utilities;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GeneralFunctions extends BaseTest {


	public void sendText(WebElement element,String text) {
		WebDriverWait myDynamicElement = new WebDriverWait(driver, 30);
		myDynamicElement.until(ExpectedConditions.visibilityOf(element));
		if (!element.getText().isEmpty()) {
			element.clear();	
		}
		element.sendKeys(text);
	}

	public void clickElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public int ExtractNoOutOfString(WebElement e) {
		String textValue = e.getText(); 
		//getting the numbers extracted from the string value
		String intValue = textValue.replaceAll("[^0-9]", "");
		//converting it to integer ! 
		int n = Integer.parseInt(intValue);
		System.out.println("The records number now is : "+n);
		return n;
	}
	
	public void CheckURL(String currentURLtoCheck) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentURLString= driver.getCurrentUrl().toString();
		Assert.assertTrue(currentURLString.contains(currentURLtoCheck));
		System.out.println("Welcome to : "+currentURLtoCheck+" Page");
	}
	

	public String getElementText(WebElement e) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String empNameAddedValueString=e.getText();
		System.out.println("The Value of element text is : "+empNameAddedValueString);
		return empNameAddedValueString;
	}
}
