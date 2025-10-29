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

public LoginPage enterUsernameAndPassword(String usernameField, String passwordField)
{
	username.sendKeys(usernameField);
	password.sendKeys(passwordField);
	return this;
}

public HomePage clickOnLoginButton()
{
	loginButton.click();
	return new HomePage(driver);
}

public boolean isHomePageDisplayed()
{
	return dashboard.isDisplayed();
}
}

