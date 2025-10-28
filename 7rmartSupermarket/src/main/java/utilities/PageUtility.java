package utilities;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	 public PageUtility(WebDriver driver) 
	 {
	        this.driver = driver;
	 }
	 
	 
	public void methodSelectByValue(WebElement element, String value)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void methodSelectByIndex(WebElement element, int value)
	{
		Select select = new Select(element);
		select.selectByIndex(value);
	}
	
	public void methodSelectByVisibleText(WebElement element, String text)
	{
		Select select= new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void methodSelectByContainsVisibleText(WebElement element, String text)
	{
		Select select= new Select(element);
		select.selectByContainsVisibleText(text);
	}
	
	public void methodDragAndDrop(WebElement drag, WebElement drop)
	{
		Actions actions= new Actions(driver);
		
		actions.moveToElement(drag).click();
		actions.doubleClick(drag).perform();
		actions.dragAndDrop(drag, drop);
		
	}
	
	 public void methodJavascriptExecuterForWindowScrolldown() 
	  {
		 JavascriptExecutor executer = (JavascriptExecutor) driver;
		 executer.executeScript("window.scrollBy(0,2000)");
		  
	  }
	 
	 public void methodJavascriptExecuterForWindowScrollUp() 
	  {
		 JavascriptExecutor executer = (JavascriptExecutor) driver;
		 executer.executeScript("window.scrollBy(0,-500)");
		  
	  }
	 public void methodJavascriptExecuterForClick(WebElement element) 
	  {
		  JavascriptExecutor executer = (JavascriptExecutor) driver;
		  executer.executeScript("arguments[0].click();",element);
		  
	  }
		
	
}
