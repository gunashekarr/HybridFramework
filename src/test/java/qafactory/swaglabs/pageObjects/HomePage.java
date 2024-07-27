/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {

	public WebDriver ldriver;
	
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"react-burger-menu-btn\"]")
	WebElement menuIcon;
	
	@FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
	WebElement logOut;
	
	@FindBy(xpath="//*[@id=\"about_sidebar_link\"]")
	WebElement aboutLink;
	
	@FindBy(xpath="//*[@id=\"reset_sidebar_link\"]")
	WebElement restLink;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[2]/div[1]/div/div/div[1]/div/div[3]/p")
	WebElement aboutMsgVerification;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[1]/div[2]")
	WebElement backPack;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	WebElement backPackCartButton;
	
	@FindBy(xpath="//*[contains(text(),'Remove')]")
	WebElement RemoveButton;
	
	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/div")
	WebElement termsAndService;
	
	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/div")
	WebElement actualUrl;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
	WebElement CartIcon;
	
	@FindBy(xpath="//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")
	WebElement backPackPriceHomePage;
	
	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a")
	WebElement twitterLink;
	
	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a")
	WebElement facebookLink;
	
	@FindBy(xpath="//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a")
	WebElement linkedinLink;
	
	public void clickMenuIcon()
	{
		menuIcon.click();
	}
	public void clickLogout()
	{
		logOut.click();
	}
	public void clickAbout()
	{
		aboutLink.click();
	}
	public void clickReset()
	{
		restLink.click();
	}
	public void validateUrl(String aUrl)
	{
		Assert.assertEquals("https://saucelabs.com/", aUrl);
	}
	public void ClickAddToCart()
	{
		backPackCartButton.click();
	}
	public boolean validateRemove()
	{
		return RemoveButton.isEnabled();
	}
	public void validateTermsAndService(String terms)
	{
		Assert.assertEquals(termsAndService.getText(), terms);
	}
	public void ClickCartIcon()
	{
		CartIcon.click();
	}
	public void ValidateBackPackPrice(String backPackPriceCartPage)
	{
		Assert.assertEquals(backPackPriceHomePage.getText(),backPackPriceCartPage);
	}
	public void ValidateHomePage(WebDriver driver,String aTitle)
	{
		Assert.assertEquals(driver.getTitle(),aTitle);
	}
	public void ValidateTwitter(WebDriver driver,String aUrl)
	{
		twitterLink.click();
		Set<String> windowHandles = driver.getWindowHandles();
		String mainWindowHandle = driver.getWindowHandle();
		for (String windowHandle : windowHandles) {
		    driver.switchTo().window(windowHandle);
		    if (driver.getTitle().equals("Sauce Labs (@saucelabs) / X")) {
		    	System.out.println("Twitter opened");
		    	Assert.assertEquals(driver.getCurrentUrl(),aUrl);
		        break;
		    }
		}
		
	}
	public void ValidateFaceBook(WebDriver driver,String aUrl)
	{
		facebookLink.click();
		Set<String> windowHandles = driver.getWindowHandles();
		String mainWindowHandle = driver.getWindowHandle();
		for (String windowHandle : windowHandles) {
		    driver.switchTo().window(windowHandle);
		    if (driver.getTitle().equals("https://www.facebook.com/saucelabs")) {
		    	Assert.assertEquals(driver.getCurrentUrl(),aUrl);
		        break;
		    }
		}
		
	}
	public void ValidateLinkedIn(WebDriver driver,String aUrl)
	{
		linkedinLink.click();
		Set<String> windowHandles = driver.getWindowHandles();
		String mainWindowHandle = driver.getWindowHandle();
		for (String windowHandle : windowHandles) {
		    driver.switchTo().window(windowHandle);
		    if (driver.getTitle().equals("https://www.linkedin.com/company/sauce-labs/")) {
		    	Assert.assertEquals(driver.getCurrentUrl(),aUrl);
		        break;
		    }
		}
		
	}
	
}
