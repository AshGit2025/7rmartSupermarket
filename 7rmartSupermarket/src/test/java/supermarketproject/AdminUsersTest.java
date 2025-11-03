package supermarketproject;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homePage;
	AdminUsers adminUsers;
	
	
  @Test(description = "verified new admin user addedd successfully", groups= {"Sanity"})
  public void createNewAdminUser() 
  {
	  LoginPage login = new LoginPage(driver);
	  login.enterUsernameAndPassword("admin", "admin");
	  homePage= login.clickOnLoginButton();
	  adminUsers= homePage.clickOnAdminUserTile();
	  String Username= FakerUtility.getFirstname();
	  String Password= FakerUtility.getPassword();
	  adminUsers.createNewAdminUser().enterAdminUsernameAndPassword(Username, Password)
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
