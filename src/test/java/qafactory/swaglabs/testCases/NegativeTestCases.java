/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import qafactory.swaglabs.pageObjects.CartPage;
import qafactory.swaglabs.pageObjects.HomePage;
import qafactory.swaglabs.pageObjects.LoginPage;
import qafactory.swaglabs.utilities.CaptureScreenShot;

public class NegativeTestCases extends BaseClass {

	@Test(groups= {"smoke", "regression"})
	public void TC01_Validate_Invalid_Username() throws IOException, InterruptedException 
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(invalidUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		lp.validateErrmsg("Epic sadface: Username and password do not match any user in this service");
     }
	@Test
	public void TC02_Validate_Invalid_Password() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(invalidPassword);
		lp.clickSubmit();
		lp.validateErrmsg("Epic sadface: Username and password do not match any user in this service");
     }
	@Test
	public void TC03_Validate_Invalid_Username_and_Password() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(invalidUserName);
		lp.setPassword(invalidPassword);
		lp.clickSubmit();
		lp.validateErrmsg("Epic sadface: Username and password do not match any user in this service");

     }
	@Test(groups= {"smoke"})
	public void TC04_Validate_Locked_Out_User() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(lockedUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		lp.validateErrmsg("Epic sadface: Sorry, this user has been locked out.");

     }
	@Test
	public void TC05_Validate_About() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		HomePage hp = new HomePage(driver);
		hp.clickMenuIcon();
		Thread.sleep(2000);
		hp.clickAbout();
		String aUrl = driver.getCurrentUrl();
		hp.validateUrl(aUrl);

     }
	@Test
	public void TC06_Validate_Error_Message() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    CartPage cp = new CartPage(driver);
	    cp.clickcheckoutButton();
	    cp.clickContinuetButton();
	    cp.ValidateErrorMessage("Error: First Name is required");
     }
	@Test
	public void TC07_Validate_FirstName_Error_Message() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    CartPage cp = new CartPage(driver);
	    cp.clickcheckoutButton();
	    cp.setFirstName("Test");
	    cp.clickContinuetButton();
	    cp.ValidateErrorMessage("Error: Last Name is required");
     }
	@Test
	public void TC08_Validate_LastName_Error_Message() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    CartPage cp = new CartPage(driver);
	    cp.clickcheckoutButton();
	    cp.setLastName("Test");
	    cp.clickContinuetButton();
	    cp.ValidateErrorMessage("Error: First Name is required");
     }
	@Test
	public void TC09_Validate_ZipCode_Error_Message() throws IOException, InterruptedException
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    CartPage cp = new CartPage(driver);
	    cp.clickcheckoutButton();
	    cp.setFirstName("Test");
	    cp.setLastName("Test");
	    cp.clickContinuetButton();
	    cp.ValidateErrorMessage("Error: First Name is required");
     }
}
