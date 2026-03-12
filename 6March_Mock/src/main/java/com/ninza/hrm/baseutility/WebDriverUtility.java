package com.ninza.hrm.baseutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// implicit wait
	public void waitForPageToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * it provides timeout
	 * 
	 * @param driver
	 */

	public void setPageLoadTimeOut(WebDriver driver) {

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

	}

	// webdriver wait obj
	public WebDriverWait webDriverObj(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;

	}

	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {

		webDriverObj(driver).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementToBeVisible(WebDriver driver, WebElement element) {

		webDriverObj(driver).until(ExpectedConditions.visibilityOf(element));
	}

	// switch window on url
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialURL)) {
				break;
			}

		}

	}

	// switch window on title
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);

			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}

		}

	}

	// Get parent window address
	public String getParentWinAddress(WebDriver driver) {
		String pwin = driver.getWindowHandle();
		return pwin;
	}

	// Get child windows address

	public Set getChildWinAddress(WebDriver driver) {
		Set<String> allwin = driver.getWindowHandles();
		return allwin;
	}

	// Switch to parent window
	public void switchToParentWin(WebDriver driver, String pwin) {
		driver.switchTo().window(pwin);
	}

	// switch to frame
	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrameByName(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);

	}

	public void switchToFrameByWebElement(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}

	// switch to alert
	public void switchToAlertAndAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndDismiss(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	// Select class

	public void selectByName(WebElement element, String text) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectByVisibleText(WebElement element, String text) {

		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectByContainsVisibleText(WebElement element, String text) {

		Select sel = new Select(element);
		sel.selectByContainsVisibleText(text);
	}

	public void selectByIndex(WebElement element, int index) {

		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// action class

	public void mousemoveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);

		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);

		act.doubleClick(element).perform();
	}

	public void actionClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

}
