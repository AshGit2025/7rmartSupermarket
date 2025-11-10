package supermarketproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	HomePage homePage;
	ManageNews manageNews;
	
  @Test
  public void createNewNews() throws IOException 
  {
	  LoginPage login=new LoginPage(driver);
	  
	  String Username=ExcelUtility.getStringData(1, 0,"AdminLoginCredential");
	  String Password=ExcelUtility.getStringData(1, 1, "AdminLoginCredential");
	  login.enterUsernameAndPassword(Username, Password);
	  homePage= login.clickOnLoginButton();
	  manageNews= homePage.clickOnManageNewsTile();
	  manageNews.clickOnNewButton().enterInputNewsField().clickOnSaveButton();
	 /* login.clickOnLoginButton();
	  
	  ManageNews manageNews=new ManageNews(driver);
	  manageNews.clickOnManageNewsTile();
	  manageNews.clickOnNewButton();
	  manageNews.enterInputNewsField();
	  manageNews.clickOnSaveButton();
	  */
	  	  
	  boolean actualMessage =  manageNews.getAlertMessage();
	  Assert.assertTrue(actualMessage, Constant.NEWSSUCCESSFULLYADDED);
	  
  }
}
