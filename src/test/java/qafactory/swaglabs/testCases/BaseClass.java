/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import qafactory.swaglabs.pageObjects.LoginPage;
import qafactory.swaglabs.utilities.CaptureScreenShot;
import qafactory.swaglabs.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	CaptureScreenShot screenshot = new CaptureScreenShot();
	public String baseUrl=readconfig.getApplicationUrl();
	public String validUserName=readconfig.getUsername();
	public String validPassword=readconfig.getValidPassword();
	public String invalidUserName=readconfig.getInValidUsername();
	public String invalidPassword=readconfig.getInValidPassword();
	public String lockedUserName=readconfig.getlockedUserName();
	public String eErrmsg=readconfig.getErrmsg();
	public String aTitle=readconfig.getTitle();
	public static WebDriver driver;
	public static Logger log;
	
	@Parameters("sbrowser")
	@BeforeClass
	public void setup(@Optional("edge")String sBrowser)
	{
		if(sBrowser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(sBrowser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	public void launchSite()
	{
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(validUserName);
		lp.setPassword(validPassword);
		lp.clickSubmit();
	}

	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
