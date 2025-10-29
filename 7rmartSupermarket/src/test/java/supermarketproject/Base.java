package supermarketproject;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ScreenshotUtility;


public class Base {
	public WebDriver driver;

	 
	  @BeforeMethod
	  public void browserInitialising() 
	  {
		  driver = new ChromeDriver();
		  driver.get("https://groceryapp.uniqassosiates.com/admin");
		  driver.manage().window().maximize();
	  }

	  @AfterMethod
	  public void captureScreenshotWhenTestCaseFail(ITestResult itResult) throws IOException 
	  {
		  if (itResult.getStatus() == ITestResult.FAILURE) {
				ScreenshotUtility sc = new ScreenshotUtility();
				sc.captureFailureScreenShot(driver, itResult.getName());
			}
			if (driver != null) {
				driver.quit();
			}
	  }
}
