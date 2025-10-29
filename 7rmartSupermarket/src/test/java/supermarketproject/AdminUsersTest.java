package supermarketproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import constance.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	HomePage homePage;
	AdminUsers adminUsers;
  @Test(description = "verified new admin user addedd successfully")
  public void createNewAdminUser() 
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameAndPassword("admin", "admin");
	  homePage= login.clickOnLoginButton();
	  adminUsers= homePage.clickOnAdminUserTile();
	  adminUsers.createNewAdminUser().enterAdminUsernameAndPassword("Mohanan", "1234")
	  .clickUserTypefield().clickOnSaveButton();
	 
	  /*login.clickOnLoginButton();
	  
	  AdminUsers adminUserTile = new AdminUsers(driver);
	  adminUserTile.clickOnAdminUserTile();
	  adminUserTile.createNewAdminUser();
	  adminUserTile.enterAdminUsernameAndPassword("Mohan","sama123");
	  adminUserTile.clickUserTypefield();
	  adminUserTile.clickOnSaveButton();
	*/  
	
	  boolean alertDisplayed =adminUsers.getSuccessMessageText();
	  Assert.assertTrue(alertDisplayed, Constant.USERALREADYEXIST);
	 	  	  
  }
}
