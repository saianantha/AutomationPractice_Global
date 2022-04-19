package info.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class EveningDressesPage extends PageObject {

	Actions action;

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	protected WebElementFacade tabDressesHomePage;

	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]//a[contains(text(),'Evening Dresses')]")
	protected WebElementFacade optionEveningDresses;

	@FindBy(xpath = "//a[contains(text(),'Printed Dress')]")
	protected WebElementFacade txtPrintedDress;

	@FindBy(id = "quantity_wanted")
	protected WebElementFacade txtQuantityWanted;

	@FindBy(xpath = "//a[@name='Beige']")
	protected WebElementFacade colourBeigeEveningPrintedDress;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	protected WebElementFacade btnAddToCart;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	protected WebElementFacade btnProceedToCheckout;
	

	@FindBy(id = "group_1")
	protected WebElementFacade dropdownSize;

	public void moveToDressesSection() {
		action = new Actions(getDriver());
		action.moveToElement(element(tabDressesHomePage)).perform();

	}

	public void navigateToEveningDresses() {
		optionEveningDresses.click();

	}

	public void selectPrintedDress() {
		action = new Actions(getDriver());
		action.moveToElement(element(txtPrintedDress)).perform();
		txtPrintedDress.click();
	}

	public void enterQuantityNeeded() {
		txtQuantityWanted.clear();
		txtQuantityWanted.sendKeys("1");
	}

	public void selectSize() {
		new Select(element(dropdownSize)).selectByVisibleText("S");

	}

	public void selectColourBeige() {
		colourBeigeEveningPrintedDress.click();
	}

	public void addToCart() {
		btnAddToCart.click();
	}

	public void checkOut() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btnProceedToCheckout.click();
		
	}
	
	
}
