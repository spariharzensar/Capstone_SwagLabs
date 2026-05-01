Feature: Cart Page Functionality

  Background:
    Given user is on the login page
    When the user enters username and password
    And clicks on the login button
    When user clicks on Add to Cart button for "Sauce Labs Bike Light" product
    When user clicks on Add to Cart button for "Sauce Labs Backpack" product
    When user clicks on the cart icon
    Then user should be redirected to the cart page

  Scenario: TC:01 Verify that cart page title is displayed correctly
    Then cart page title should be "Your Cart"

  Scenario: TC:02 Verify that added item is displayed in cart
    Then cart should contain item "Sauce Labs Backpack"

  Scenario: TC:03 Verify that item price is displayed correctly
    Then item "Sauce Labs Backpack" should have a valid price

  Scenario: TC:04 Verify that user can remove item from cart
    When user removes item "Sauce Labs Backpack"
    Then cart should not contain item "Sauce Labs Backpack"

  Scenario: TC:05 Verify that cart item count is correct
    Then cart item count should be 2

  Scenario: TC:06 Verify that user can navigate to inventory page using continue shopping
    When user clicks on continue shopping
    Then user should be redirected to the inventory page

  Scenario: TC:07 Verify that user can navigate to checkout page
    When user clicks on checkout
    Then user should be redirected to checkout page

  Scenario: TC:08 Verify that user can remove all items from cart
    When user removes all items
    Then cart should be empty

  Scenario: TC:09 Verify that cart badge updates after item removal
    When user removes item "Sauce Labs Backpack"
    Then cart badge should show 1

  Scenario: TC:10 Verify that cart items persist after page refresh
    When user refreshes the page
    Then cart should contain item "Sauce Labs Backpack"