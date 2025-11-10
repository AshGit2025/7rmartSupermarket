package supermarketproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pages.AdminUsers;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homePage;
	AdminUsers adminUsers;
	
	
	
  @Test(description = "verified new admin user addedd successfully", groups= {"Sanity"})
  public void createNewAdminUser() throws IOException 
  {
	  LoginPage login = new LoginPage(driver);
	  String Username=ExcelUtility.getStringData(1, 0,"AdminLoginCredential");
	  String Password=ExcelUtility.getStringData(1, 1, "AdminLoginCredential");
	  
	  login.enterUsernameAndPassword(Username, Password);
	  homePage= login.clickOnLoginButton();
	  adminUsers= homePage.clickOnAdminUserTile();
	  String adminUsername= FakerUtility.getFirstname();
	  String adminPassword= FakerUtility.getPassword();
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
