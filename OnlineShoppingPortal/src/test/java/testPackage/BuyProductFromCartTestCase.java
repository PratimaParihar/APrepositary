package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomeListner;
import genericPackage.Flib;
import genericPackage.WorkLib;
import pomPackage.CheckOutPage;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomeListner.class)

public class BuyProductFromCartTestCase extends BaseTest {
  @Test
  public void buyProductFromCartMethod() throws EncryptedDocumentException, IOException, InterruptedException {
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
		wp.getShoppingCartLink().click();
		
		el.getSmartPhoneCartItem().click();
		el.getRemoveProductCheckBox().click();
		el.getTermsServiceCheckBox().click();
		el.getCheckOutButton().click();
		
		CheckOutPage cp = new CheckOutPage(driver);
		
		WorkLib wl = new WorkLib();
		//wl.selectByVisibleTextMethod(cp.getBillingAddressCountryDropDown(),"India");
		//wl.selectByVisibleTextMethod(cp.getShippingAddressDropDown(),"Dange Chowk");
		cp.buyProductNewMethod();
		
  }
}
