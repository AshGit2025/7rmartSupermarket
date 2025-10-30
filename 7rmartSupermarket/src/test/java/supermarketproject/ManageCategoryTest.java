package supermarketproject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constance.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;
import utilities.ExcelUtility;
import utilities.PageUtility;


public class ManageCategoryTest extends Base {
	HomePage homePage;
	ManageCategory manageCategory;
	
  @Test
  public void ToVerifyAddNewCategory() throws IOException 
  {
	  
	  LoginPage login = new LoginPage(driver);
	  String Username = ExcelUtility.getStringData(1, 0, "AdminLoginCredential");
	  String Password = ExcelUtility.getStringData(1, 1, "AdminLoginCredential"); 
	  login.enterUsernameAndPassword(Username, Password);
	  homePage = login.clickOnLoginButton();
	  manageCategory = homePage.clickOnManageCategoryTile();
	  manageCategory.clickOnAddNewCategoryButton().clickOnEnterCategory()
	  .clickOnSelectGroup().clickOnChooseFile().methodJavascriptExecuterForWindowScrolldown()
	  .clickOnRadioButton2OfShowOnTopMenu().clickOnRadioButton3OfShowOnLeftMenu().waitForSaveButton()
	  .clickOnSavebutton();
	  
	  /*login.clickOnLoginButton();
	  
	  boolean loginCheck=login.isHomePageDisplayed();
	  Assert.assertTrue(loginCheck, Constant.ERRORMESSAGEFORLOGIN);
	  
	  ManageCategory manageCategory = new ManageCategory(driver);
	  manageCategory.clickOnManageCategoryTile();
	  manageCategory.clickOnAddNewCategoryButton();
	  manageCategory.clickOnEnterCategory();
	  manageCategory.clickOnSelectGroup();
	  manageCategory.clickOnChooseFile(); 
	  manageCategory.methodJavascriptExecuterForWindowScrolldown();
	  
	  manageCategory.clickOnRadioButton2OfShowOnTopMenu();
	  manageCategory.clickOnRadioButton3OfShowOnLeftMenu();
	  
	  manageCategory.waitForSaveButton();
	  manageCategory.clickOnSavebutton();
	 */ 
	  
	  boolean alertDisplayed =manageCategory.checkAlertDisplayed();
	  Assert.assertTrue(alertDisplayed, Constant.USERALREADYEXIST);
	  
  }
  
 
}
