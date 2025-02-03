package pomPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericPackage.BaseTest;

public class RegisterPage extends BaseTest {
	// Declaration
	@FindBy(id="gender-male")private WebElement maleRadioButton;
	@FindBy(id="gender-female")private WebElement femaleRadioButton;
	@FindBy(id="FirstName") private WebElement firstNameTB;
	@FindBy(id="LastName")private WebElement lastNameTB;
	@FindBy(id="Email") private WebElement emailTB;
	@FindBy(id="Password")private WebElement passwordTB;
	@FindBy(id="ConfirmPassword") private WebElement confirmPasswordTB;
	@FindBy(id="register-button")private WebElement registerButton;
	
	//Initailization
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilize

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getFirstNameTB() {
		return firstNameTB;
	}

	public WebElement getLastNameTB() {
		return lastNameTB;
	}

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getConfirmPasswordTB() {
		return confirmPasswordTB;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	//operational methods
	public void registerUser(String fn, String Ln,String email,String pwd) {
		femaleRadioButton.click();
		firstNameTB.sendKeys(fn);
		lastNameTB.sendKeys(Ln);
		emailTB.sendKeys(email);
		passwordTB.sendKeys(pwd);
		confirmPasswordTB.sendKeys(pwd);
		registerButton.click();
	}
}
