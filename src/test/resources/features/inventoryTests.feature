@inventory
Feature: Inventory Page Functionality

  Background:
    Given user is on the login page
    When user enters username and password
    And clicks on the login button

  Scenario: TC-01 Verify user lands on inventory page after login
    Then user should be redirected to the inventory page

  Scenario: TC-02 Verify all products are displayed
    Then user should be redirected to the inventory page
    Then all 5 products should be visible

  Scenario: TC-03 Verify product details are displayed
    Then user should be redirected to the inventory page
    Then all 6 products should display name and price details

  Scenario: TC-04 Verify user can add a product to cart
    Then user should be redirected to the inventory page
    When user clicks on Add to Cart button for "Sauce Labs Backpack" product
    Then the product should be added to the cart

  Scenario: TC-05 Verify cart badge updates after adding product
    Then user should be redirected to the inventory page
    When user clicks on Add to Cart button for "Sauce Labs Bike Light" product
    When user clicks on Add to Cart button for "Sauce Labs Bolt T-Shirt" product
    Then cart badge count should be updated to 2

  Scenario: TC-06 Verify user can remove product from cart
    Then user should be redirected to the inventory page
    When user clicks on Add to Cart button for "Sauce Labs Bike Light" product
    When user clicks on Remove button for "Sauce Labs Bolt T-Shirt" product
    Then product should be removed from the cart

  Scenario: TC-07 Verify product name click navigates to detail page
    Then user should be redirected to the inventory page
    When user clicks on "Sauce Labs Backpack" product
    Then user should be navigated to the product detail page

  Scenario: TC-08 Verify sorting by Name (A to Z)
    Then user should be redirected to the inventory page
    When user selects "Name (A to Z)" from sort dropdown
    Then products should be sorted in ascending alphabetical order

  Scenario: TC-09 Verify sorting by Price (Low to High)
    Then user should be redirected to the inventory page
    When user selects "Price (low to high)" from sort dropdown
    Then products should be sorted in ascending price order

  Scenario: TC-10 Verify user can navigate to cart page
    Then user should be redirected to the inventory page
    When user clicks on the cart icon
    Then user should be redirected to the cart page