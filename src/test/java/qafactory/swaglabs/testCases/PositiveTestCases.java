/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.testCases;

import java.io.IOException;
import java.time.Duration;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qafactory.swaglabs.pageObjects.CartPage;
import qafactory.swaglabs.pageObjects.HomePage;
import qafactory.swaglabs.pageObjects.LoginPage;
import qafactory.swaglabs.utilities.CaptureScreenShot;
// @Listeners(qafactory.swaglabs.utilities.MyListener.class) 
public class PositiveTestCases extends BaseClass {

	@Test(priority=0,groups = "Smoke")
	public void TC01_Validate_Login() throws IOException, InterruptedException 
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ValidateHomePage(driver, driver.getTitle());
		screenshot.ScreenShot("TC01_Validate_Login()", driver);
    }
	
	@Test(priority=1,groups = "Regression",dependsOnMethods = "TC01_Validate_Login")
	public void TC02_Validate_Logout() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.clickMenuIcon();
		hp.clickLogout();
        lp.validateLoginPage();
        screenshot.ScreenShot("TC02_Validate_Logout()", driver);
     }
	
	@Test(priority=3)
	public void TC03_Validate_About() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.clickMenuIcon();
		hp.clickAbout();
		String aUrl = driver.getCurrentUrl();
		hp.validateUrl(aUrl);
		screenshot.ScreenShot("TC03_Validate_About()", driver);
     }
	
	@Test(priority=2)
	public void TC04_Validate_RemoveButton() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
        hp.ClickAddToCart();
		hp.validateRemove();
		screenshot.ScreenShot("TC04_Validate_RemoveButton()", driver);
     }
	
	@Test
	public void TC05_Validate_Terms() throws IOException, InterruptedException
	{
		launchSite();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		HomePage hp = new HomePage(driver);
		hp.validateTermsAndService("© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
		screenshot.ScreenShot("TC05_Validate_Terms()", driver);
     }
	
	@Test
	public void TC06_Validate_Price_in_CartPage() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    hp.ValidateBackPackPrice("$29.99");
	    screenshot.ScreenShot("TC06_Validate_Price_in_CartPage()", driver);
     }
	@Test(groups = "Smoke")
	public void TC07_Validate_Product_Purchase() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    CartPage cp = new CartPage(driver);
	    cp.clickcheckoutButton();
	    cp.setFirstName("Guna");
	    cp.setLastName("Shekar");
	    cp.setZip("560085");
	    cp.clickContinuetButton();
	    cp.ValidateProductDetails("$29.99");
	    cp.clickFinishButton();
	    cp.ValidateOrderConfirmation("Thank you for your order!");
	    screenshot.ScreenShot("TC07_Validate_Product_Purchase()", driver);
	    
     }
	
	@Test
	public void TC08_Validate_Product_Purchase_Cancel_Flow() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ClickAddToCart();
	    hp.ClickCartIcon();
	    CartPage cp = new CartPage(driver);
	    cp.clickcheckoutButton();
	    cp.setFirstName("Guna");
	    cp.setLastName("Shekar");
	    cp.setZip("560085");
	    cp.clickContinuetButton();
	    cp.ValidateProductDetails("$29.99");
	    cp.ClickCancelButton();
	    hp.ValidateHomePage(driver, aTitle);
	    screenshot.ScreenShot("TC08_Validate_Product_Purchase_Cancel_Flow()", driver);
	    
     }
	@Test
	public void TC09_Validate_Twitter() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ValidateTwitter(driver, "https://x.com/saucelabs");
		screenshot.ScreenShot("TC09_Validate_Twitter()", driver);
	    
     }
	
	@Test
	public void TC10_Validate_Facebook() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ValidateTwitter(driver, "https://www.facebook.com/saucelabs");
		screenshot.ScreenShot("TC10_Validate_Facebook()", driver);
	    
     }
	@Test
	public void TC11_Validate_LinkedIn() throws IOException, InterruptedException
	{
		launchSite();
		HomePage hp = new HomePage(driver);
		hp.ValidateTwitter(driver, "https://www.linkedin.com/company/sauce-labs/");
		screenshot.ScreenShot("TC11_Validate_LinkedIn()", driver);
	    
     }
}	
