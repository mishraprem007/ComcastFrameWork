package com.comcast.crm.generic.genericwebdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) {  //used url
				break;
			}
		}
	}
		public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);
				String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(partialTitle)) {  //used url
					break;
				}
			}
	}
		 public void switchToFrame(WebDriver driver,int index) {
			 driver.switchTo().frame(index);
		 }
		 public void switchToFrame(WebDriver driver,String nameOrId) {
			 driver.switchTo().frame(nameOrId);
		 }
		 public void switchToFrame(WebDriver driver,WebElement frameElement) {
			 driver.switchTo().frame(frameElement);
		 }
		 public void switchToAlertAndAccept(WebDriver driver) {
			 driver.switchTo().alert().accept();
		 }
		 public void switchToAlertAndDismiss(WebDriver driver) {
			 driver.switchTo().alert().dismiss();
		 }
		 public void selectbyindex(WebElement element,int index) {
				Select obj = new Select(element);	
				obj.selectByIndex(index);	
				}
				public void selectByvalue(WebElement element,String value) {
					Select obj = new Select(element);	
					obj.selectByValue(value);	
					}
				public void selectbyVisibleText(WebElement element,String text) {
					Select obj = new Select(element);	
					obj.selectByVisibleText(text);	
					}
				public void mouseHoverOnWebElement(WebDriver driver,WebElement element) {
					Actions action = new Actions(driver);
					action.moveToElement(element).perform();
				}
				public void doubleClick(WebDriver driver,WebElement element) {
					Actions action = new Actions(driver);
					action.doubleClick(element).perform();	
				}
				 public void rightClick(WebDriver driver,WebElement element) {
					 Actions action = new Actions(driver);
						action.contextClick(element).perform();
				 }
}
