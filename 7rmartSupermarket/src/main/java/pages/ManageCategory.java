package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constance.Constant;
import utilities.FileUploadUtility;

public class ManageCategory {
	
	public WebDriver driver;
	FileUploadUtility upload = new FileUploadUtility();
	
	public ManageCategory (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[9]") WebElement manageCategoryTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement NewButton;
	@FindBy(xpath="//input[@type='text']") WebElement enterCategory;
	@FindBy(id="134-selectable") WebElement selectGroup;
	@FindBy(xpath="//input[@id='main_img']") WebElement chooseFileButton;
	@FindBy(xpath="(//label[@class='radio-inline'])[2]") WebElement radio2;
	@FindBy(xpath="(//label[@class='radio-inline'])[3]") WebElement radio3;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alert;
	
	public void clickOnManageCategoryTile()
	{
		manageCategoryTile.click();
	}
	
	public void clickOnAddNewCategoryButton()
	{
		NewButton.click();
	}
	
	public void clickOnEnterCategory()
	{
		enterCategory.sendKeys(" category info as Veerapan");
	}
	
	public void clickOnSelectGroup()
	{
		selectGroup.click();
	}
	
	public void clickOnChooseFile()
	{
		upload.sendKeysForFileUpload(chooseFileButton, Constant.IMAGEFILE);
	}
	
	
	//robot class method
	
	
	public void clickOnRadioButton2OfShowOnTopMenu()
	{
		radio2.click();
	}

	public void clickOnRadioButton3OfShowOnLeftMenu()
	{
		radio3.click();
	}
	
	public void clickOnSavebutton()
	{
		saveButton.click();
	}
	
	public boolean checkAlertDisplayed()
	{
		alert.isDisplayed();
		return true;
	}
}
