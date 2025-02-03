package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomeListner.class)

public class InvalidLoginTestCase extends BaseTest{
  @Test
  public void invalidLoginMethod() throws EncryptedDocumentException, IOException, InterruptedException
  {
	WelcomePage wp = new WelcomePage(driver); 
	wp.getLoginLink().click();
	
	Flib flib = new Flib();	
	int rc = flib.getLastRowCount(EXCEL_PATH, "InvalidLoginCreds");
	
	LoginPage lp = new LoginPage(driver);
	
	for(int i=1;i<=rc;i++)
	{
		lp.invalidLogin(flib.readExcelData( EXCEL_PATH,"InvalidLoginCreds",i,0),flib.readExcelData(EXCEL_PATH, "InvalidLoginCreds", i, 1));
	}	
  }
}
