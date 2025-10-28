package supermarketproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import constance.Constant;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends Base {

	 @Test
	  public void verifyLogout() 
	  {
		  LoginPage loginpage = new LoginPage(driver);
		  loginpage.enterUsernameAndPassword("admin", "admin");
		  loginpage.clickOnLoginButton();
		  
		  HomePage homepage = new HomePage(driver);
		  homepage.clickOnUser();
		  homepage.clickOnLogout();
		  
		  String expected ="Login | 7rmart supermarket1";
		  String actual= driver.getTitle();
		  Assert.assertEquals(actual, expected, Constant.FAILEDLOGOUT);
		  
	  }
}
