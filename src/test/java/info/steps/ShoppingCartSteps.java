package info.steps;

import info.pageObjects.CartSummaryPage;
import info.pageObjects.EveningDressesPage;
import info.pageObjects.ShoppingCartPages;
import info.pageObjects.SummerDressesPage;
import info.pageObjects.TshirtHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ShoppingCartSteps extends ScenarioSteps {
	ShoppingCartPages shoppingCartPages;
	TshirtHomePage tshirtHomePage;
	EveningDressesPage eveningDressesHomePage;
	SummerDressesPage summerDressesHomePage;
	CartSummaryPage cartSummaryPage;

	@Step
	public void launchURL() {
		getDriver().get("http://automationpractice.com/index.php");
		getDriver().manage().window().maximize();
		// shoppingCartPages.moveToElementFadedTShirt();
		// shoppingCartPages.selectDresses();
	}

	@Step
	public void addTshirtToTheCart() {
		tshirtHomePage.navigateToTshirtsHomePage();
		tshirtHomePage.selectFadedTShirt();
		tshirtHomePage.enterQuantityNeeded();
		tshirtHomePage.selectSize();
		tshirtHomePage.selectColour();
		tshirtHomePage.addFadedTshirtToCart();
		tshirtHomePage.closeWindow();
	}

	@Step
	public void addEveningDressToTheCart() {
		eveningDressesHomePage.moveToDressesSection();
		eveningDressesHomePage.navigateToEveningDresses();
		eveningDressesHomePage.selectPrintedDress();
		eveningDressesHomePage.enterQuantityNeeded();
		eveningDressesHomePage.selectSize();
		eveningDressesHomePage.selectColourBeige();
		eveningDressesHomePage.addToCart();
		tshirtHomePage.closeWindow();


	}
	
	@Step
	public void addPrintedSummerDressToTheCart() {
		summerDressesHomePage.moveToDressesSection();
		summerDressesHomePage.navigateToSummerDresses();
		summerDressesHomePage.selectPrintedSummerDress();
		summerDressesHomePage.enterQuantityNeeded();
		summerDressesHomePage.selectColourOrange();
		summerDressesHomePage.addToCart();
		
	}
	
	@Step
	public void navigateToCheckOutPage() {
		eveningDressesHomePage.checkOut();
		
	}
	
	@Step
	public void removeEveningDressFromCart() {
		cartSummaryPage.removeEveningDressFromCart();
		
	}
	
	@Step
	public Double cartSummary() {
		cartSummaryPage.moveToCart();
		cartSummaryPage.navigateToCheckOutPage();
		cartSummaryPage.scrollWindowDown();
		Double totalPrice = cartSummaryPage.cartSummaryTotalPrice();
		return totalPrice;
		
	}
	
	
	@Step
	public Double totalProductsAmountSummary() {
		Double totalPrice = cartSummaryPage.totalProductsPrice();
		return totalPrice;
	}
	
	
	
	

}
