package testHomepage;

import static com.Utility.UIkeywords.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.BaseClass;

public class SignIn extends BaseClass{
//	UIkeywords keyword = UIkeywords.getInstance();
	@Test(priority=-1)
	public void signIn() throws InterruptedException {
		launchURL("https://www.ijmeet.com");
		click("css", "li:nth-child(4) a.nav-link");
		enterText("mak@gmail.com", "css", "input#email");
		enterText("Mak@12345", "css", "input#password");
		click("css", "button[type=\"submit\"]");
		String actualUrl = getCurrentURL();
		Assert.assertTrue(actualUrl.contains("dashboard"));
	}
	
}
