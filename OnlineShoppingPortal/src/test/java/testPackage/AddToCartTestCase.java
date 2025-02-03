package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomeListner.class)
public class AddToCartTestCase extends BaseTest{
  @Test
  public void addToCartMethod() throws EncryptedDocumentException, IOException, InterruptedException {
	  WelcomePage wp = new WelcomePage(driver);
	  wp.getLoginLink().click();
	  Flib flib=new Flib();
		String email=flib.readExcelData(EXCEL_PATH, "ValidLoginCreds", 1, 0);
		String pwd=flib.readExcelData(EXCEL_PATH, "ValidLoginCreds", 1, 1);
		
		LoginPage lp=new LoginPage(driver);
		lp.validLogin(email, pwd);
		
		wp.getElectronicsLink().click();
		ElectronicsPage el = new ElectronicsPage(driver);
		el.addToCart();
		
  }
}
