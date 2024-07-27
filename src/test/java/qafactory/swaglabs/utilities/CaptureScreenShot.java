/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.utilities;

/**
 * @author 91895
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class CaptureScreenShot {
	
	public WebDriver driver;

	            public String ScreenShot(String testCaseName,WebDriver driver) throws IOException
	        	{
//	            	Capturing a date and time
	            	String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // current time stamp
	        		
	        		TakesScreenshot ts = (TakesScreenshot)driver;
	        		File source = ts.getScreenshotAs(OutputType.FILE);
//	        		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+"_"+timestamp+".png";
	        		File destination = new File("./Screenshots/"+testCaseName+"_"+timestamp+".png");
	        		FileUtils.copyFile(source,destination);
	        		return destination.getAbsolutePath();        		 		
	        	}
	            public String ScreenShotBase64()
	        	{
                 	TakesScreenshot ts = (TakesScreenshot)driver;
	        		String base64Code = ts.getScreenshotAs(OutputType.BASE64);
	        		return base64Code;        		 		
	        	}
	    }