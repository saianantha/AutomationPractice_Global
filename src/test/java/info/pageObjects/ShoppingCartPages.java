package info.pageObjects;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPages extends PageObject {

	@FindBy(xpath = "//input[@name='email']")
	protected WebElementFacade txtUsername;

	@FindBy(xpath = "//input[@name='password']")
	protected WebElementFacade txtPassword;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	protected WebElementFacade btnAddToCart;

	@FindBy(xpath = "(//a[text()='T-shirts'])[2]")
	protected WebElementFacade tabTShirtsHomePage;

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	protected WebElementFacade tabDressesHomePage;

	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	protected WebElementFacade txtFadedTShirt;

	@FindBy(xpath = "//a[contains(text(),'Printed Dress')]")
	protected WebElementFacade txtPrintedDress;

	@FindBy(id = "quantity_wanted")
	protected WebElementFacade txtQuantityWanted;

	@FindBy(id = "group_1")
	protected WebElementFacade dropdownSize;

	@FindBy(xpath = "//a[@name='Blue']")
	protected WebElementFacade colourBlueFadedTShirt;

	@FindBy(xpath = "//a[@name='Beige']")
	protected WebElementFacade colourBeigeEveningPrintedDress;

	@FindBy(xpath = "//span[@title='Close window']")
	protected WebElementFacade closeWindow;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]//a[contains(text(),'Summer Dresses')]")
	protected WebElementFacade btnSummerDresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]//a[contains(text(),'Casual Dresses')]")
	protected WebElementFacade btnCasualDresses;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]//a[contains(text(),'Evening Dresses')]")
	protected WebElementFacade btnEveningDresses;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	protected WebElementFacade btnProceedToCheckout;
	

	public void moveToElementFadedTShirt() {
		tabTShirtsHomePage.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Actions action = new Actions(getDriver());
		action.moveToElement(element(txtFadedTShirt)).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtFadedTShirt.click();
		txtQuantityWanted.clear();
		txtQuantityWanted.sendKeys("1");
		action.moveToElement(element(btnAddToCart)).perform();
		// dropdownSize.selectByValue("2");
		colourBlueFadedTShirt.click();
		btnAddToCart.click();
		closeWindow.click();

	}

	public void selectDresses() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Actions action = new Actions(getDriver());
		action.moveToElement(element(tabDressesHomePage)).perform();
		btnEveningDresses.click();
		action.moveToElement(element(txtPrintedDress)).perform();
		txtPrintedDress.click();
		txtQuantityWanted.clear();
		txtQuantityWanted.sendKeys("1");
		colourBeigeEveningPrintedDress.click();
		btnAddToCart.click();
		btnProceedToCheckout.click();
		

	}

}
