/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"user-name\"]")
	WebElement username;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3/text()")
	WebElement aErrmsg;
	
	@FindBy(xpath="//*[@id=\"header_container\"]/div[2]/span")
	WebElement products;
	
	public void setUsername(String uname)
	{
		username.sendKeys(uname);
	}
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clickSubmit()
	{
		loginbtn.click();
	}
	public void validateErrmsg(String eErrmsg)
	{
		Assert.assertEquals(aErrmsg, eErrmsg);
	}
	public boolean validateHomePage()
	{
		return products.isDisplayed();
	}
	public boolean validateLogin()
	{
		return aErrmsg.getText().isBlank();
	}
	
}
