package info.pageObjects;

import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SummerDressesPage extends PageObject {
	Actions action;
	
	@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]//a[contains(text(),'Summer Dresses')]")
	protected WebElementFacade optionSummerDresses;
	
	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	protected WebElementFacade tabDressesHomePage;
	
	@FindBy(xpath = "(//a[contains(text(),'Printed Summer Dress')])[1]")
	protected WebElementFacade txtPrintedSummerDress;
	
	@FindBy(id = "quantity_wanted")
	protected WebElementFacade txtQuantityWanted;
	
	@FindBy(xpath = "//a[@name='Orange']")
	protected WebElementFacade colourOrangeSummerPrintedDress;
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	protected WebElementFacade btnAddToCart;

	public void moveToDressesSection() {
		action = new Actions(getDriver());
		action.moveToElement(element(tabDressesHomePage)).perform();

	}

	public void navigateToSummerDresses() {
		optionSummerDresses.click();

	}
	
	public void selectPrintedSummerDress() {
		action = new Actions(getDriver());
		action.moveToElement(element(txtPrintedSummerDress)).perform();
		txtPrintedSummerDress.click();
	}
	
	public void enterQuantityNeeded() {
		txtQuantityWanted.clear();
		txtQuantityWanted.sendKeys("1");
	}

	public void selectSize() {	

	}

	public void selectColourOrange() {
		colourOrangeSummerPrintedDress.click();
	}

	public void addToCart() {
	//	action.moveToElement(element(btnAddToCart)).perform();
		btnAddToCart.click();
	}
	

}
