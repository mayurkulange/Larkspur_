package testHomepage;

import static com.Utility.UIkeywords.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.config.BaseClass;

@Test
public class ContactSales extends BaseClass{
	//UIkeywords keyword = UIkeywords.getInstance();
public void contactSales() {
	launchURL("https://www.ijmeet.com");
	click("css", "li:nth-child(3) a.nav-link");
	enterText("Mayur kulange", "css", "input[name=\"user_name\"]");
	enterText("mak@gmail.com", "css", "input[name=\"user_email\"]");
	enterText("Hello How are you?", "css", "textarea[name=\"user_message\"]");
	WebElement element = getDriver().findElement(By.cssSelector("iframe[title=\"reCAPTCHA\"]"));
	switchToFrame(0);
	click("css", "div.recaptcha-checkbox-border");
	switchToDefaultContent();
	//Thread.sleep(2000);
	click("css", "button[type=\"submit\"]");
}
}
