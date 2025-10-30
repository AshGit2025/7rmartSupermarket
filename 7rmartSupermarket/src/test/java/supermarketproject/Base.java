package supermarketproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constance.Constant;
import utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;
	public Properties properties;
	public FileInputStream fis;

	@BeforeMethod
	@Parameters("browser")
	public void browserInitialising(String browser) throws Exception {
		try {
			properties = new Properties();
			fis = new FileInputStream(Constant.PAGEURL);
			properties.load(fis);
     		} 
		catch (FileNotFoundException exception) 
		{
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) 
		
		{
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) 
		
		{
			driver = new FirefoxDriver();
		} else 
		
		{
			throw new Exception("invalid browser");
		}
		// driver = new ChromeDriver();
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void captureScreenshotWhenTestCaseFail(ITestResult itResult) throws IOException {
		if (itResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility sc = new ScreenshotUtility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
		if (driver != null) {
			driver.quit();
		}
	}
}
