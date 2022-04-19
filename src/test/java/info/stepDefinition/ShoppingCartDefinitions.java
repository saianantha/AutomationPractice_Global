package info.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import info.reusables.customEnsure;
import info.steps.ShoppingCartSteps;

public class ShoppingCartDefinitions {

	Double totalEachItemSumPrice, totalSummaryPrice;

	@Steps
	ShoppingCartSteps shoppingCartSteps;

	@Given("I login to the home page")
	public void i_login_to_the_home_page() {
		shoppingCartSteps.launchURL();

	}

	@When("I add the product {string} with size {string} colour {string}")
	public void i_add_the_product_with_size_colour(String nameOfProduct, String size, String colour) {
		if (nameOfProduct.equalsIgnoreCase("Faded Short Sleeve") && colour.equalsIgnoreCase("Blue"))
			shoppingCartSteps.addTshirtToTheCart();
		if (nameOfProduct.equalsIgnoreCase("Evening Dress") && colour.equalsIgnoreCase("Beige"))
			shoppingCartSteps.addEveningDressToTheCart();
		if (nameOfProduct.equalsIgnoreCase("Printed Summer Dress") && colour.equalsIgnoreCase("Orange"))
			shoppingCartSteps.addPrintedSummerDressToTheCart();

	}

	@When("navigates to checkout page")
	public void navigates_to_checkout_page() {
		shoppingCartSteps.navigateToCheckOutPage();

	}

	@When("I remove {string} from the cart")
	public void i_remove_from_the_cart(String string) {
		shoppingCartSteps.removeEveningDressFromCart();

	}

	@When("I assert each line item in the cart")
	public void i_assert_each_line_item_in_the_cart() {
		totalEachItemSumPrice = shoppingCartSteps.cartSummary();
	}

	@Then("cart total is matching with {string}")
	public void cart_total_is_matching_with(String string) {
		totalSummaryPrice = shoppingCartSteps.totalProductsAmountSummary();
		Double compare = (double) Double.compare(totalEachItemSumPrice, totalSummaryPrice); 
		if (compare == 0) {
			customEnsure.customLogWithoutScreenShot("Total amount matched with value" + totalSummaryPrice, "Pass");
		} else {
			customEnsure.customLogWithoutScreenShot(
					"Mismatch in values expected::" + totalSummaryPrice + "Actual value::" + totalEachItemSumPrice,
					"Fail");
		}

	}

}
