package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomeListner.class)

public class RemoveProductFromCartTestCase extends BaseTest {
  @Test
  public void removeProductMethod() throws EncryptedDocumentException, IOException, InterruptedException {
	  WelcomePage wp = new WelcomePage(driver);
	  wp.getLoginLink().click();
	
	  LoginPage lp=new LoginPage(driver);

	  Flib flib=new Flib();
		String email=flib.readExcelData(EXCEL_PATH, "ValidLoginCreds", 1, 0);
		String pwd=flib.readExcelData(EXCEL_PATH, "ValidLoginCreds", 1, 1);
		
		lp.validLogin(email, pwd);
		Thread.sleep(1000);

		wp.getShoppingCartLink().click();
		
		
		ElectronicsPage el = new ElectronicsPage(driver);
		Thread.sleep(1000);

		el.getRemoveProductCheckBox().click();
		el.getUpdateCartButton().click();
		
	
		//SoftAssert sa = new SoftAssert();
		//sa.assertEquals(el.getSmartPhoneCartItem().isDisplayed(), false, "Product is not removed from cart");
	  
  }
}
