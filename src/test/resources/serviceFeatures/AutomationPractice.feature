Feature: Add products to the cart and checkout functionality
  As a user I want to add products to the cart modify the cart and assert the total
  
  @shoppingCart
  Scenario: Validate if customer is able to add products to the cart and verify the total amount
    Given I login to the home page
    When I add the product "Faded Short Sleeve" with size "Medium" colour "Blue"
    And I add the product "Evening Dress" with size "Small" colour "Beige"
    And I add the product "Printed Summer Dress" with size "Medium" colour "Orange"
    And navigates to checkout page
    And I remove "Evening Dress" from the cart
    And I add the product "Faded Short Sleeve" with size "Medium" colour "Blue"
    And I assert each line item in the cart
    Then cart total is matching with "$65.53"

      
