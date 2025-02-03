package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import pomPackage.RegisterPage;
import pomPackage.WelcomePage;
@Listeners(CustomeListner.class)

public class RegisterTestCase extends BaseTest {
  @Test
  
  public void registerMethod() throws EncryptedDocumentException, IOException {
	  
	 WelcomePage wp= new WelcomePage(driver);
	 wp.getRegisterLink().click();
	 
	 
	RegisterPage rp=new RegisterPage(driver);
	
	Flib flib=new Flib();
	String fn=flib.readExcelData(EXCEL_PATH, "RegisterCreds", 1, 0);
	String Ln=flib.readExcelData(EXCEL_PATH, "RegisterCreds", 1, 1);
	String email=flib.readExcelData(EXCEL_PATH, "RegisterCreds", 1, 2);
	String pwd=flib.readExcelData(EXCEL_PATH, "RegisterCreds", 1, 3);
	
	rp.registerUser(fn, Ln, email, pwd);
	 
  }
}
