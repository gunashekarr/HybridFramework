/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.utilities;
// Listener class used to generate Extent Reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onTestStart(ITestContext testContext)
	{
		 System.out.println("Test Execution is started");
//		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // current time stamp
//		String repName = "Test-Report-"+timestamp+".html";
//		System.out.println("filename--->"+repName);
		// Designed the Report Structure
//		htmlreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/"+repName);
		 sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/ExtentReports/MyReport.html");
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
	public void onTestSuccess(ITestResult tr)
	{
		test = extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath);
		if(f.exists())
		{
				test.fail("Screenshot is below:"+test.addScreenCaptureFromPath(screenshotPath));
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	public void onTestFinish(ITestResult testContext)
	{
		extent.flush();
	}

}
