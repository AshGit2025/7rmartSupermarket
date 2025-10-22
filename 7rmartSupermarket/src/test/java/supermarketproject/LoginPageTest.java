package supermarketproject;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constance.Constant;
import pages.LoginPage;

public class LoginPageTest extends Base {

	@Test
	@Parameters({"Username", "Password"})
	  	  public void verifyValidCredentials(String Username, String Password)
	  {
		  LoginPage login = new LoginPage(driver);
		  login.enterUsernameAndPassword(Username, Password);
		  login.clickOnLoginButton();
		  
		  //checking assertion
		  boolean isHomePage=login.isHomePageDisplayed();
		  Assert.assertTrue(isHomePage, Constant.ERRORMESSAGEFORLOGIN);
	  }
	
	@Test
	  public void verifyInValidCredentials() 
	  {
		  LoginPage login = new LoginPage(driver);
		  login.enterUsernameAndPassword("Ash", "123");
		  login.clickOnLoginButton();
	  }
	  
	  @Test
	  public void verifycredentialsWithCorrectPassword() 
	  {
		  LoginPage login = new LoginPage(driver);
		  login.enterUsernameAndPassword("ASHHHH", "admin");
		  login.clickOnLoginButton();
	  }
	  
	  @Test (dataProvider = "dataProvider")
	  public void verifycredentialsWithCorrectUsername(String Username, String Password) 
	  {
		  LoginPage login = new LoginPage(driver);
		  login.enterUsernameAndPassword(Username, Password);
		  login.clickOnLoginButton();
	  }
	  
	  @DataProvider(name="dataProvider")
	  public Object testData()
	  {
		  Object data[][] = {{"admin","admin"},{"admin","345"}};
		  return data;
		  
	  }
}
