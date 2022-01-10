package testHomepage;
import com.constant.LocatorType;
import com.Utility.PropUtil;
import com.Utility.UIkeywords;
import com.constant.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import com.config.BaseClass;
import static com.Utility.UIkeywords.*;

@Test
public class SignUp extends BaseClass{
//	UIkeywords keyword = UIkeywords.getInstance();
	public void signUp() {
		launchURL("https://www.ijmeet.com");
		PropUtil prop = new PropUtil();
	//	enterText(getTitleOfPage(), getCurrentURL())
		click(prop.getLocator("signup.login")[0],prop.getLocator("signup.login")[1]);
//		enterText(prop.getLocator("signup.fullname")[0], prop.getLocator("signup.fullname")[1]);
		click(Locator.homeScreen_SignUpBtn);
	//	click(LocatorType.css,"li:nth-child(5) a.nav-link" );
	//	enterText("Mayur", LocatorType.css, "input#name");
		enterText(Locator.name,"Mayur");
		enterText(Locator.companyName,"TCS");
		enterText(Locator.contactNumber, "8605674997");
		enterText(Locator.emailID, "mayurkulange@gmail.com");
		enterText(Locator.password, "zvlbofbn578");
		click(Locator.submitBtn);
		
		/*enterText("Resonantia", LocatorType.css, "input#company_name");
		enterText( "8605674997",LocatorType.css, "input#contact");
		enterText( "mak@gmail.com",LocatorType.css, "input#email");
		enterText("dbsrb1a16413",LocatorType.css, "input#password");*/
		switchToFrame(0);
		click(LocatorType.css, "div.recaptcha-checkbox-border");
		switchToDefaultContent();
	//	click(LocatorType.css, "button[type=\"submit\"]");
	}




}
