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
	
	//@FindBy(xpath="//a[@class='nav-link']//child::img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']") WebElement user;
	@FindBy(xpath="(//a[@class='nav-link'])[2]") WebElement user;
	
	@FindBy(xpath="(//a[@class='dropdown-item'])[2]") WebElement logout;
	
	public void clickOnUser()
	{
	
		user.click();
			
	}
	public void clickOnLogout()
	{
			logout.click();			
	}
}
