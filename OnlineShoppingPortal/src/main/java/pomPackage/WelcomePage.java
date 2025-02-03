package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import genericPackage.BaseTest;

public class WelcomePage extends BaseTest {
	
	// Declaration 
	@FindBy(linkText = "Register") private WebElement registerLink;
	@FindBy(linkText = "Log in") private WebElement loginLink;
	@FindBy(xpath = "//span[text()='Shopping cart']")private WebElement shoppingCartLink;
	@FindBy(xpath = "//span[text()='Wishlist']") private WebElement wishListLink;
	@FindBy(id = "small-searchterms") private WebElement searchStoreTB;
	@FindBy(xpath = "//input[@type='submit']") private WebElement searchButton;
	@FindBy(partialLinkText = "Books") private WebElement booksLink;
	@FindBy(partialLinkText = "Computers") private WebElement computersLink;
	@FindBy(partialLinkText = "Electronics") private WebElement electronicsLink;
	@FindBy(partialLinkText = "Apparel & Shoes") private WebElement apparelShoesLink;
	@FindBy(partialLinkText = "Digital downloads") private WebElement digitalDownloadsLink;
	@FindBy(partialLinkText = "Jewelry") private WebElement jewelryLink;
	@FindBy(partialLinkText = "Gift Cards") private WebElement giftCardsLink;
	
	
	//Initailization
	
	public  WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization


	public WebElement getRegisterLink() {
		return registerLink;
	}


	public WebElement getLoginLink() {
		return loginLink;
	}


	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}


	public WebElement getWishListLink() {
		return wishListLink;
	}


	public WebElement getSearchStoreTB() {
		return searchStoreTB;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}


	public WebElement getBooksLink() {
		return booksLink;
	}


	public WebElement getComputersLink() {
		return computersLink;
	}


	public WebElement getElectronicsLink() {
		return electronicsLink;
	}


	public WebElement getApparelShoesLink() {
		return apparelShoesLink;
	}


	public WebElement getDigitalDownloadsLink() {
		return digitalDownloadsLink;
	}


	public WebElement getJewelryLink() {
		return jewelryLink;
	}


	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}
	
	
}
