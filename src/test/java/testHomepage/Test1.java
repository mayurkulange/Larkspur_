package testHomepage;

import static com.Utility.UIkeywords.*;

import org.apache.xpath.compiler.Keywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.BaseClass;
@Test
public class Test1 extends BaseClass{
//	UIkeywords keyword = UIkeywords.getInstance();
	public void testTitle() {
		launchURL("https://www.ijmeet.com");
		String expTitle = "IJmeet";
		String title =getTitleOfPage();
		Assert.assertEquals(title, expTitle);
	
	}

}
