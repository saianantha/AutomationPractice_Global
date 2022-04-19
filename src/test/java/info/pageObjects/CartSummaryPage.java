package info.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartSummaryPage extends PageObject {

	@FindBy(xpath = "//a[@title='View my shopping cart']")
	protected WebElementFacade cartSummary;

	@FindBy(xpath = "//span[contains(text(),'Check out')]")
	protected WebElementFacade checkOutButton;
	
	
	@FindBy(xpath = "//td[@id='total_product']")
	protected WebElementFacade totalProducts;

	public void removeEveningDressFromCart() {
		getDriver()
				.findElement(By.xpath(
						"//table[@id='cart_summary']/tbody/tr[@id='product_4_16_0_0']//td[@data-title='Delete']"))
				.click();
	}

	public void moveToCart() {
		Actions action = new Actions(getDriver());
		action.moveToElement(element(cartSummary)).perform();

	}

	public Double cartSummaryTotalPrice() {
		String price;
		String[] priceSplit;
		Double totalInDouble = 0.00;
		Double newTotal = 0.00;
 	List<WebElement> totalProductsPriceWebElements = getDriver()
				.findElements(By.xpath("//td[@data-title='Total']/span[@class='price']"));

		if (totalProductsPriceWebElements.size() > 1) {
			for (int i = 1; i <= totalProductsPriceWebElements.size(); i++) {
				price = getDriver().findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[" + i
						+ "]//td[@data-title='Total']/span[@class='price']")).getText();
				
				priceSplit = price.split("\\$");
				totalInDouble = Double.parseDouble(price.split("\\$")[1]);
				newTotal = newTotal + totalInDouble;
			
			}
		}
		
		System.out.println(newTotal);
		return newTotal;

	}
	
	public Double totalProductsPrice() {
		Double totalInDouble =0.00;
		String strAmount = element(totalProducts).getText();
		totalInDouble = Double.parseDouble(strAmount.split("\\$")[1]);
		return totalInDouble ;
	}

	public void navigateToCheckOutPage() {
		checkOutButton.click();

	}

	public void scrollWindowDown() {
		JavascriptExecutor je = (JavascriptExecutor) getDriver();
		je.executeScript("window.scrollBy(0,500)", "");
	}

}
