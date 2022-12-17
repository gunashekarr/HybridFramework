/** @author Gunashekar R
 *  gunashekarr11@gmail.com
 */
package qafactory.swaglabs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Expection is" + e.getMessage());
			System.out.println("Expection is" + e.getCause());
			System.out.println("Expection is" + e.getStackTrace());
		}
	}
		public String getApplicationUrl()
		{
			String url=pro.getProperty("baseUrl");
			return url;
		}
		public String getUsername()
		{
			String username=pro.getProperty("baseUrl");
			return username;
		}
		public String getValidPassword()
		{
			String validpassword=pro.getProperty("validPassword");
			return validpassword;
		}
		public String getInValidPassword()
		{
			String invalidpassword=pro.getProperty("invalidPassword");
			return invalidpassword;
		}
		public String getErrmsg()
		{
			String errmsg=pro.getProperty("eErrmsg");
			return errmsg;
		}
		public String getTitle()
		{
			String title=pro.getProperty("aTitle");
			return title;
		}
		public String getUrl()
		{
			String url=pro.getProperty("eUrl");
			return url;
		}
}
