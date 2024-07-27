/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

	public WebDriver ldriver;
	
	public CartPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"checkout\"]")
	WebElement checkoutButton;
	
	@FindBy(xpath="//*[@id=\"first-name\"]")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"last-name\"]")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"postal-code\"]")
	WebElement zipCode;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	WebElement continueButton;	
	
	@FindBy(xpath="//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3")
	WebElement Error;
	
	@FindBy(xpath="//*[@id=\"finish\"]")
	WebElement finishButton;
	
	@FindBy(xpath="//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
	WebElement price;
	
	@FindBy(xpath="//*[@id=\"checkout_complete_container\"]/h2")
	WebElement orderConfirmed;
	
	@FindBy(xpath="//*[@id=\"cancel\"]")
	WebElement cancelButton;	

	public void clickcheckoutButton()
	{
		checkoutButton.click();
	}
	public void clickFinishButton()
	{
		finishButton.click();
	}
	public void clickContinuetButton()
	{
		continueButton.click();
	}
	public void setFirstName(String fName)
	{
		firstName.sendKeys(fName);
	}
	public void setLastName(String LName)
	{
		lastName.sendKeys(LName);
	}
	public void setZip(String ZipCode)
	{
		zipCode.sendKeys(ZipCode);
	}
	public void ValidateErrorMessage(String exErrMsg)
	{
		Assert.assertEquals(Error.getText(),exErrMsg);
	}
	
	public void ValidateProductDetails(String aprice)
	{
		Assert.assertEquals(price.getText(),aprice);
	}
	
	public void ValidateOrderConfirmation(String orderConfirmedMsg)
	{
		Assert.assertEquals(orderConfirmed.getText(),orderConfirmedMsg);
	}
	public void ClickCancelButton()
	{
		cancelButton.click();
	}
	
}
