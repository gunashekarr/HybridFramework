/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import qafactory.swaglabs.pageObjects.LoginPage;
import qafactory.swaglabs.utilities.XLUtils;

public class DataDriven_Login extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd)
	{
		launchSite();
		Assert.assertEquals(readconfig.getUrl(),driver.getCurrentUrl());
	}	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException 
	{
		String path = System.getProperty("user.dir") + "/src/test/java/qafactory/swaglabs/testData/TestData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Login");
		int colcount = XLUtils.getCellCount(path, "Login", 1);

		String loginData[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Login", i, j);
			}
		}
		return loginData;
	}
}
