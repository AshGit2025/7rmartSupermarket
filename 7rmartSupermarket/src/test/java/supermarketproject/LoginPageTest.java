package supermarketproject;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {

	@Test(description = "To check login with valid credential")
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
	
	@Test(groups = {"Smoke"})
	  public void verifyInValidCredentials() throws IOException 
	  {
		  LoginPage login = new LoginPage(driver);
		  String Username=ExcelUtility.getStringData(1, 0,"LoginPageTest");
		  String Password=ExcelUtility.getIntegerData(1, 1, "LoginPageTest");
		  login.enterUsernameAndPassword(Username,Password);
		  login.clickOnLoginButton();
	  }

	  @Test (groups = {"Smoke"})
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
