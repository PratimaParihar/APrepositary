package pomPackage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericPackage.BaseTest;

public class LoginPage extends BaseTest {
	
	//Declaration
	@FindBy(id="Email")private WebElement LoginEmailTB;
	@FindBy(id="Password")private WebElement LoginPasswordTB;
	@FindBy(id="RememberMe")private WebElement LoginRememberMeCheckBox;
	@FindBy(linkText = "Forgot password?")private WebElement LoginForgetPasswordLink;
	@FindBy(xpath = "//input[@value='Log in']")private WebElement LPLoginButton;
	
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLoginEmailTB() {
		return LoginEmailTB;
	}

	public WebElement getLoginPasswordTB() {
		return LoginPasswordTB;
	}

	public WebElement getLoginRememberMeCheckBox() {
		return LoginRememberMeCheckBox;
	}

	public WebElement getLoginForgetPasswordLink() {
		return LoginForgetPasswordLink;
	}

	public WebElement getLPLoginButton() {
		return LPLoginButton;
	}
	
	//Operational method
	public void validLogin(String email, String pwd) throws InterruptedException
	{
		LoginEmailTB.sendKeys(email);
		LoginPasswordTB.sendKeys(pwd);
		LPLoginButton.click();
		Thread.sleep(1000);
		
	}
	public void invalidLogin(String email, String pwd) throws InterruptedException
	{
		LoginEmailTB.sendKeys(email);
		LoginPasswordTB.sendKeys(pwd);
		LPLoginButton.click();
		Thread.sleep(1000);
		LoginEmailTB.clear();
	}
	
}
