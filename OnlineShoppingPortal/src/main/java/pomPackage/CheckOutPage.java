package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericPackage.BaseTest;
import genericPackage.Flib;
import genericPackage.WorkLib;

public class CheckOutPage extends BaseTest{
	//Declarations
	@FindBy(id="BillingNewAddress_CountryId")private WebElement BillingAddressCountryDropDown;
	@FindBy(id="BillingNewAddress_City")private WebElement BillingAddressCityTB;
	@FindBy(id="BillingNewAddress_Address1")private WebElement BillingAddressAddress1TB;
	@FindBy(id="BillingNewAddress_ZipPostalCode")private WebElement BillingAddressZipCodeTB;
	@FindBy(id="BillingNewAddress_PhoneNumber")private WebElement BillingAddressPhoneNumberTB;
	@FindBy(xpath="//input[@onclick='Billing.save()']")private WebElement BillingAddressContiuneButton;
	@FindBy(id="shipping-address-select")private WebElement ShippingAddressDropDown;
	//@FindBy(xpath="//input[@class='button-1 payment-info-next-step-button']]")private WebElement CheckOutShippingContinueButton;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")private WebElement ShippingAddressContinueButton;
	@FindBy(id="shippingoption_0")private WebElement ShippingMethodRadio1Button;
	@FindBy(id="shippingoption_1")private WebElement ShippingMethodNewDayRadioButton;
	@FindBy(id="shippingoption_2")private WebElement ShippingMethodSecondDayRadioButton;
	@FindBy(xpath="//input[@onclick='ShippingMethod.save()']")private WebElement ShippingMethodContinueButton;
	@FindBy(id="paymentmethod_0")private WebElement PaymentMethodRadioButton;
	@FindBy(xpath="//input[@onclick='PaymentMethod.save()']")private WebElement PaymentMethodContinueButton;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")private WebElement PaymentInfoContinueButton;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")private WebElement ConfirmOrderContiuneButton;
	@FindBy(xpath = "//strong[text()='Your order has been successfully processed!']")private WebElement OrderConfirmText;
	@FindBy(id="billing-address-select")private WebElement BillingNewAddressDropDown;
	
	
	//Initialization
	public CheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization


	public WebElement getBillingAddressCountryDropDown() {
		return BillingAddressCountryDropDown;
	}


	public WebElement getBillingNewAddressDropDown() {
		return BillingNewAddressDropDown;
	}


	public WebElement getBillingAddressCityTB() {
		return BillingAddressCityTB;
	}


	public WebElement getBillingAddressAddress1TB() {
		return BillingAddressAddress1TB;
	}


	public WebElement getBillingAddressZipCodeTB() {
		return BillingAddressZipCodeTB;
	}


	public WebElement getBillingAddressPhoneNumberTB() {
		return BillingAddressPhoneNumberTB;
	}


	public WebElement getBillingAddressContiuneButton() {
		return BillingAddressContiuneButton;
	}


	public WebElement getShippingAddressDropDown() {
		return ShippingAddressDropDown;
	}

	
//	public WebElement getCheckOutShippingContinueButton() {
//		return CheckOutShippingContinueButton;
//	}

	
	
	
	


	public WebElement getShippingAddressContinueButton() {
		return ShippingAddressContinueButton;
	}


	public WebElement getShippingMethodRadio1Button() {
		return ShippingMethodRadio1Button;
	}


	public WebElement getShippingMethodNewDayRadioButton() {
		return ShippingMethodNewDayRadioButton;
	}


	public WebElement getShippingMethodSecondDayRadioButton() {
		return ShippingMethodSecondDayRadioButton;
	}


	public WebElement getShippingMethodContinueButton() {
		return ShippingMethodContinueButton;
	}


	public WebElement getPaymentMethodRadioButton() {
		return PaymentMethodRadioButton;
	}


	public WebElement getPaymentMethodContinueButton() {
		return PaymentMethodContinueButton;
	}


	public WebElement getPaymentInfoContinueButton() {
		return PaymentInfoContinueButton;
	}


	public WebElement getConfirmOrderContiuneButton() {
		return ConfirmOrderContiuneButton;
	}


	public WebElement getOrderConfirmText() {
		return OrderConfirmText;
	}
	



	//Operational Method
	public void buyProductNewMethod() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		WorkLib wl = new WorkLib();
		try {
		if(BillingNewAddressDropDown.isDisplayed()==true)
		{
			wl.selectByVisibleTextMethod(BillingNewAddressDropDown, "New Address");
		}
		}
		catch(Exception e)
		{
			wl.selectByVisibleTextMethod(BillingAddressCountryDropDown, "India");
		}	
		
		finally {
		wl.selectByVisibleTextMethod(BillingAddressCountryDropDown, "India");	
		Flib flib = new Flib();
		String City = flib.readExcelData(EXCEL_PATH, "buyproductdata", 1, 0);
		String Address1 = flib.readExcelData(EXCEL_PATH, "buyproductdata", 1, 1);
		long ZipCOde = flib.readExcelData1(EXCEL_PATH, "buyproductdata", 1, 2);
		long PhoneNum = flib.readExcelData1(EXCEL_PATH, "buyproductdata", 1, 3);
		int rn = flib.randomNumber();
		
		String PhoneNum1= PhoneNum + " " +rn;
		
		BillingAddressCityTB.sendKeys(City);
		BillingAddressAddress1TB.sendKeys(Address1);
		BillingAddressZipCodeTB.sendKeys(String.valueOf(ZipCOde));
		BillingAddressPhoneNumberTB.sendKeys(String.valueOf(PhoneNum1));
		BillingAddressContiuneButton.click();

		//ShippingAddressDropDown.click();
		
		//CheckOutShippingContinueButton.click();
		
		ShippingAddressContinueButton.click();
		
		ShippingMethodRadio1Button.click();
		ShippingMethodContinueButton.click();
		PaymentMethodRadioButton.click();
		PaymentMethodContinueButton.click();
		PaymentInfoContinueButton.click();
		ConfirmOrderContiuneButton.click();
		Thread.sleep(1000);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(OrderConfirmText.isDisplayed(), true, "Order is Confirmed");
		sa.assertAll();
		
		}
	}
}
	
