package supermarketproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import constance.Constant;
import pages.AdminUsers;
import pages.LoginPage;

public class AdminUsersTest extends Base {
  @Test(description = "verified new admin user addedd successfully")
  public void createNewAdminUser() 
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameAndPassword("admin", "admin");
	  login.clickOnLoginButton();
	  
	  AdminUsers adminUserTile = new AdminUsers(driver);
	  adminUserTile.clickOnAdminUserTile();
	  adminUserTile.createNewAdminUser();
	  adminUserTile.enterAdminUsernameAndPassword("Mohan","sama123");
	  adminUserTile.clickUserTypefield();
	  adminUserTile.clickOnSaveButton();
	  
	  adminUserTile.getSuccessMessageText();
	  boolean alertDisplayed =adminUserTile.getSuccessMessageText();
	  Assert.assertTrue(alertDisplayed, Constant.USERALREADYEXIST);
	 	  	  
  }
}
