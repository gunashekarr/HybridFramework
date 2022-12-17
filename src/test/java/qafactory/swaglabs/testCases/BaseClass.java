/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import qafactory.swaglabs.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseUrl=readconfig.getApplicationUrl();
	public String username=readconfig.getUsername();
	public String validPassword=readconfig.getValidPassword();
	public String invalidPassword=readconfig.getInValidPassword();
	public String eErrmsg=readconfig.getErrmsg();
	public String aTitle=readconfig.getTitle();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		driver=WebDriverManager.edgedriver().create();
		driver.manage().window().maximize();
		
//		logger=Logger.getLogger(getClass());
//		PropertyConfigurator.configure("log4j.properties");
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
