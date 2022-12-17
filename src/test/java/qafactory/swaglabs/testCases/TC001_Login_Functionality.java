/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import qafactory.swaglabs.pageObjects.LoginPage;

public class TC001_Login_Functionality extends BaseClass {

	@Test
	public void ValidLogin() {
		driver.get(baseUrl);
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(validPassword);
		lp.clickSubmit();
		if (driver.getTitle().equals(aTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}
}
