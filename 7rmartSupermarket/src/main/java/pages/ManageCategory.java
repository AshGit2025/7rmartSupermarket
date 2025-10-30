package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constance.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategory {
	
	public WebDriver driver;
	FileUploadUtility upload = new FileUploadUtility();
	
	public ManageCategory (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement NewButton;
	@FindBy(xpath="//input[@type='text']") WebElement enterCategory;
	@FindBy(id="134-selectable") WebElement selectGroup;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFileButton;
	@FindBy(xpath="(//label[@class='radio-inline'])[2]") WebElement radio2;
	@FindBy(xpath="(//label[@class='radio-inline'])[3]") WebElement radio3;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	
	
	public ManageCategory clickOnAddNewCategoryButton()
	{
		NewButton.click();
		return this;
	}
	
	public ManageCategory clickOnEnterCategory()
	{
		enterCategory.sendKeys(" category info as Veerapan");
		return this;
	}
	
	public ManageCategory clickOnSelectGroup()
	{
		selectGroup.click();
		return this;
	}
	
	public ManageCategory clickOnChooseFile()
	{
		upload.sendKeysForFileUpload(chooseFileButton, Constant.IMAGEFILE);
		return this;
	}
	
	public ManageCategory methodJavascriptExecuterForWindowScrolldown() 
	  {
		 JavascriptExecutor executer = (JavascriptExecutor) driver;
		 executer.executeScript("window.scrollBy(0,40000)");
		 return this;
	  }
	
	public ManageCategory clickOnRadioButton2OfShowOnTopMenu()
	{
		radio2.click();
		return this;
	}

	public ManageCategory clickOnRadioButton3OfShowOnLeftMenu()
	{
		radio3.click();
		return this;
	}
	
	public ManageCategory waitForSaveButton()
	{
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToClick(driver, saveButton);
		return this;
	}
	
	
	public ManageCategory clickOnSavebutton()
	{
		saveButton.click();
		return this;
	}
	
	public boolean checkAlertDisplayed()
	{
		alert.isDisplayed();
		return true;
	}
}
