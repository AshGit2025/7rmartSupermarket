package supermarketproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import constance.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNews;

public class ManageNewsTest extends Base {
	
	HomePage homePage;
	ManageNews manageNews;
	
  @Test
  public void createNewNews() 
  {
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameAndPassword("admin", "admin");
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
