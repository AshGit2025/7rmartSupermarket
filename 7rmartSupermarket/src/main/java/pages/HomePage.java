package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

public WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//a[@class='nav-link'])[2]") WebElement user;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]") WebElement logout;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") WebElement adminUserTile;
	
	public HomePage clickOnUser()
	{
	
		user.click();
		return this;
			
	}
	public HomePage clickOnLogout()
	{
			logout.click();	
			return this;
	}
	public AdminUsers clickOnAdminUserTile()
	{
		adminUserTile.click();
		return new AdminUsers(driver);
	}
}
