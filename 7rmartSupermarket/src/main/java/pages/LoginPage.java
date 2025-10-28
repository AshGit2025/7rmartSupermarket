package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	public WebDriver driver;
  
	public LoginPage (WebDriver driver)
 {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
 }

  @FindBy(xpath="//input[@type='text']") WebElement username;
  @FindBy(xpath="//input[@type='password']") WebElement password;
  @FindBy(xpath="//button[@type='submit']") WebElement loginButton;
  @FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard; // adding assertion

public void enterUsernameAndPassword(String usernameField, String passwordField)
{
	username.sendKeys(usernameField);
	password.sendKeys(passwordField);
}

public void clickOnLoginButton()
{
	loginButton.click();
}

public boolean isHomePageDisplayed()
{
	return dashboard.isDisplayed();
}
}

