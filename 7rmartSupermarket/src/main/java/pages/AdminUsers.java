package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsers {
	
	// Section1 --> Driver  & PageFactory initial
	// Section2 --> @FindBy elements using Locators
    // Section3 --> Methods
	// Section4 --> Assertion element defining method
	
	
	public WebDriver driver;
	
	PageUtility pageUtility = new PageUtility(driver);
	WaitUtility waitUtility= new WaitUtility();
	
	public AdminUsers (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") WebElement adminUserTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(id="username") WebElement usernameTextField;
	@FindBy(xpath="(//input[@class='form-control'])[3]") WebElement passwordTextField;
	@FindBy(xpath="(//select[@class='form-control'])[2]") WebElement userTypeDropDown;
	@FindBy(xpath="(//button[@type='submit'])[2]") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
	
	
	
	public void clickOnAdminUserTile()
	{
		adminUserTile.click();
	}
	
	public void createNewAdminUser()
	{
		newButton.click();
	}
	
	public void enterAdminUsernameAndPassword(String Username, String Password)
	{
		usernameTextField.sendKeys(Username);
		passwordTextField.sendKeys(Password);
	}
		
	public void clickUserTypefield()
	{
		pageUtility.methodSelectByValue(userTypeDropDown, "staff");
	//	Select selectUserType = new Select(userTypeDropDown);
		//selectUserType.selectByValue("staff");
	}
	
	public void clickOnSaveButton()
	{		
		waitUtility.waitForElementToClick(driver,saveButton );
		saveButton.click();
	}
	
	public boolean getSuccessMessageText()
	{
		return successAlert.isDisplayed();
	}

	
}
