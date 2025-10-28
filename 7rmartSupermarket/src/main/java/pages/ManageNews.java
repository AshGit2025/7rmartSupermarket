package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {

	public WebDriver driver;
	
	public ManageNews(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='small-box-footer'])[7]") WebElement manageNewsTile;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//textarea[@id='news']") WebElement newsInputField;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	
	public void clickOnManageNewsTile()
	{
		manageNewsTile.click();
	}
	
	public void clickOnNewButton()
	{
		newButton.click();
	}
	
	public void enterInputNewsField()
	{
		newsInputField.sendKeys("Veerappan Killed in an Encounter!!");
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	public boolean getAlertMessage()
	{
		return successMessage.isDisplayed();
	}
	
}
