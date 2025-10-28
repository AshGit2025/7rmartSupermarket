package supermarketproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import constance.Constant;
import pages.LoginPage;
import pages.ManageNews;

public class ManageNewsTest extends Base {
  @Test
  public void createNewNews() 
  {
	  LoginPage login=new LoginPage(driver);
	  login.enterUsernameAndPassword("admin", "admin");
	  login.clickOnLoginButton();
	  
	  ManageNews manageNews=new ManageNews(driver);
	  manageNews.clickOnManageNewsTile();
	  manageNews.clickOnNewButton();
	  manageNews.enterInputNewsField();
	  manageNews.clickOnSaveButton();
	  
	  manageNews.getAlertMessage();
	  
	  boolean actualMessage =  manageNews.getAlertMessage();
	  Assert.assertTrue(actualMessage, Constant.NEWSSUCCESSFULLYADDED);
	  
  }
}
