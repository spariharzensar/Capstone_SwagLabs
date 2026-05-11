Feature: Check out Functionality

  Background:
    Given user is on the login page
    When the user enters username and password
    And clicks on the login button
    When user clicks on Add to Cart button for "Sauce Labs Bike Light" product
    #When user clicks on Add to Cart button for "Sauce Labs Backpack" product
    When user clicks on the cart icon
    Then user should be redirected to the cart page
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters firstname, lastname and postalcode



    Scenario: Verify whether user can navigate to checkout complete page

      And clicks on Continue
      Then user should be redirected to the checkoutOverview Page
      When user clicks on Finish
      Then user should be redirected to checkout complete page

      Scenario: Verify whether user can navigate back to inventory page
        And clicks on Continue
        Then user should be redirected to the checkoutOverview Page
        When  user clicks on Cancel
        Then user should be redirected to the inventory page



