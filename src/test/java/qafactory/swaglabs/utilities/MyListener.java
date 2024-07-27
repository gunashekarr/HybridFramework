/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import qafactory.swaglabs.testCases.BaseClass;

public class MyListener extends CaptureScreenShot implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // current time stamp
		String repName = "Test-Report-"+timestamp+".html";

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		sparkReporter.config().setDocumentTitle("QaFactory Automation report");
		sparkReporter.config().setReportName("Functional Report");
		sparkReporter.config().setTheme(Theme.DARK);

		// Designed the Report Details
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter); // link to report structure
		extent.setSystemInfo("Hostname","QaFactory_Host");
		extent.setSystemInfo("Browser","Edge");
		extent.setSystemInfo("Author","Gunashekar R");	
	}


	public void onTestStart(ITestResult result) {	
	}
		 
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case PASSED is:" + result.getName());
		test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
	}


	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed is:" + result.getName());
		test.log(Status.FAIL, "Test case Failed is:" + result.getThrowable());
		
//		WebDriver driver=null;
//		String testMethodName=result.getMethod().getMethodName();
//		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		
//		try {
//			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////		test.get().addScreenCaptureFromPath(screenshot(testMethodName, driver),testMethodName);
//		
//		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+testMethodName+"_"+timestamp+".png";
//		
//		try {
//			FileHandler.copy(srcScreenshot, new File(destination));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		test.fail("details").addScreenCaptureFromPath(destination);
		test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
		
	}


	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case skipped is:" + result.getName());
	}
	
	public void onFinish(ITestContext context) {
		 extent.flush();
	}

	

}
