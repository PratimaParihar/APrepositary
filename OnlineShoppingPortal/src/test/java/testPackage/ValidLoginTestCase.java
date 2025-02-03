package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomeListner.class)

public class ValidLoginTestCase extends BaseTest{

@Test
  public void validLoginMethod() throws EncryptedDocumentException, IOException, InterruptedException {
	WelcomePage wp=new WelcomePage(driver);
	wp.getLoginLink().click();
	
	Flib flib=new Flib();
	String email=flib.readExcelData(EXCEL_PATH, "ValidLoginCreds", 1, 0);
	String pwd=flib.readExcelData(EXCEL_PATH, "ValidLoginCreds", 1, 1);
	
	LoginPage lp=new LoginPage(driver);
	lp.validLogin(email, pwd);
  }
}
