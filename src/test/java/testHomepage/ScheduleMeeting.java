package testHomepage;

import static com.Utility.UIkeywords.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.BaseClass;

public class ScheduleMeeting extends BaseClass{
//	UIkeywords keyword = UIkeywords.getInstance();
	private static final Logger LOG = Logger.getLogger(ScheduleMeeting.class);
	@Test
	public void scheduleMeeting()   {
		launchURL("https://www.ijmeet.com");
		click("css", "li:nth-child(4) a.nav-link");
		enterText("mak@gmail.com", "css", "input#email");
		enterText("Mak@12345", "css", "input#password");
		click("css", "button[type=\"submit\"]");
		String actualUrl = getCurrentURL();
		LOG.info("url is "+actualUrl);
		Assert.assertTrue(actualUrl.contains("dashboard"));
		click("css", "div.schedule-new-meet-btn div");
		enterText("Larkspur21A", "css", "input#edit_topic");
		enterText("Meeting start on 11am", "css", "div.col-lg-9 textarea");
		enterText("All students of TS", "css", "input[list=\"browsers\"]");
		selectBy("css", "select#edit_hour", "byindex", "2");
		selectBy("css", "select#edit_minute", "byindex", "1");
		selectBy("css", "select#edit_timezone", "byvalue", "Asia/Kolkata");
		selectBy("css", "select#email_template_language", "byindex", "0");
		click("css", "label.form-check-label");
		click("css", "span.slider");
	//	click("xpath", "//input[@id=\"meet_participant_upon_enter\"]/following-sibling::em");
	//	scrollBy(300);
	//	click("css", "div div div div div label input[name='mute_participants']+em");
		click("css", "input#submitmeeting");
	}
}
