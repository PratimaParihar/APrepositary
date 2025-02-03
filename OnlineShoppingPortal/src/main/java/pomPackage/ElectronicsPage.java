package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import genericPackage.BaseTest;

public class ElectronicsPage extends BaseTest{
	//Declarations
	@FindBy(partialLinkText = "Camera, photo")private WebElement CameraPhotoLink;
	@FindBy(partialLinkText = "Cell phones")private WebElement CellPhoneLink;
	@FindBy(xpath = "//a[text()='Smartphone']/../..//input[@value='Add to cart']")private WebElement CellPhoneAddToCartButton;
	

	@FindBy(xpath = "(//a[text()='Smartphone'])[2]/../preceding-sibling::td[@class='product-picture']/img")private WebElement SmartPhoneCartItem;
	@FindBy(xpath = "//span[text()='Shopping cart']")private WebElement EPShoppingCartLink;

	@FindBy(xpath = "(//a[text()='Smartphone'])[2]/../..//input[@name='removefromcart']")private WebElement RemoveProductCheckBox;
	@FindBy(name = "updatecart")private WebElement UpdateCartButton;
	@FindBy(name = "termsofservice")private WebElement termsServiceCheckBox;
	@FindBy(id = "checkout")private WebElement CheckOutButton;
	
	//Initialization
	public ElectronicsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCameraPhotoLink() {
		
		return CameraPhotoLink;
	}
	public WebElement getCellPhoneLink() {
		return CellPhoneLink;
	}
	public WebElement getCellPhoneAddToCartButton() {
		return CellPhoneAddToCartButton;
	}
	public WebElement getEPShoppingCartLink() {
		return EPShoppingCartLink;
	}
	public WebElement getSmartPhoneCartItem() {
		return SmartPhoneCartItem;
	}		
	
	public WebElement getRemoveProductCheckBox() {
		return RemoveProductCheckBox;
	}

	public WebElement getUpdateCartButton() {
		return UpdateCartButton;
	}
	
	
	public WebElement getTermsServiceCheckBox() {
		return termsServiceCheckBox;
	}

	public WebElement getCheckOutButton() {
		return CheckOutButton;
	}

	//Operational
	public void addToCart() throws InterruptedException
	{
		CellPhoneLink.click();			
		CellPhoneAddToCartButton.click();
		EPShoppingCartLink.click();
		SmartPhoneCartItem.click();
		
		Thread.sleep(2000);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(SmartPhoneCartItem.isDisplayed(), true, "Product is not displayed in the Cart");	
		
//		termsServiceCheckBox.click();
//		CheckOutButton.click();
	}
}
