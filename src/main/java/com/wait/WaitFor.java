package com.wait;

import static com.Utility.UIkeywords.*;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {
	public static WebDriverWait wait;
	static {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void visibilityOfElement(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void elementToClickable(WebElement element, int duration) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public void stalenessOf(int duration, WebElement element) {
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.stalenessOf(element));
		wait.ignoring(NoSuchElementException.class);
	}
}
