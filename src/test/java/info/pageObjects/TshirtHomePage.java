package info.pageObjects;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TshirtHomePage extends PageObject {

	@FindBy(xpath = "(//a[text()='T-shirts'])[2]")
	protected WebElementFacade tabTShirtsHomePage;

	@FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
	protected WebElementFacade txtFadedTShirt;

	@FindBy(id = "quantity_wanted")
	protected WebElementFacade txtQuantityWanted;

	@FindBy(id = "group_1")
	protected WebElementFacade dropdownSize;

	@FindBy(xpath = "//a[@name='Blue']")
	protected WebElementFacade colourBlueFadedTShirt;

	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	protected WebElementFacade btnAddToCart;

	@FindBy(xpath = "//span[@title='Close window']")
	protected WebElementFacade closeWindow;

	public void navigateToTshirtsHomePage() {
		tabTShirtsHomePage.click();
	}

	public void selectFadedTShirt() {
		Actions action = new Actions(getDriver());
		action.moveToElement(element(txtFadedTShirt)).perform();
		txtFadedTShirt.click();
	}

	public void enterQuantityNeeded() {
		txtQuantityWanted.clear();
		txtQuantityWanted.sendKeys("1");
	}

	public void selectSize() {
		new Select(element(dropdownSize)).selectByVisibleText("M");

	}

	public void selectColour() {
		colourBlueFadedTShirt.click();
	}

	public void addFadedTshirtToCart() {
		btnAddToCart.click();
	}

	public void closeWindow() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeWindow.click();
	}
}