package supermarketproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base {

	HomePage homePage;
	
	 @Test(retryAnalyzer = retry.Retry.class, description = "Verified logout after admin login")
	  public void verifyLogout() throws IOException 
	  {
		  LoginPage loginpage = new LoginPage(driver);
		 
		  String Username=ExcelUtility.getStringData(1, 0,"AdminLoginCredential");
		  String Password=ExcelUtility.getStringData(1, 1, "AdminLoginCredential");
		  loginpage.enterUsernameAndPassword(Username, Password);
		  
		  homePage= loginpage.clickOnLoginButton();
		  homePage.clickOnUser().clickOnLogout();
		  
		 /* loginpage.clickOnLoginButton();
		  
		  HomePage homepage = new HomePage(driver);
		  homepage.clickOnUser();
		  homepage.clickOnLogout();
		  */
		  String expected ="Login | 7rmart supermarket";
		  String actual= driver.getTitle();
		  Assert.assertEquals(actual, expected, Constant.FAILEDLOGOUT);
		  
	  }
}
