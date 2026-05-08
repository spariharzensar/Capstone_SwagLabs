Feature: Check out Functionality

  Background:
    Given user is on the login page
    When the user enters username and password
    And clicks on the login button
    When user clicks on Add to Cart button for "Sauce Labs Bike Light" product
    #When user clicks on Add to Cart button for "Sauce Labs Backpack" product
    When user clicks on the cart icon
    Then user should be redirected to the cart page

  Scenario: TC:01 Verify that user can navigate to checkoutOverview page
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters firstname, lastname and postalcode
    And clicks on Continue
    Then user should be redirected to the checkoutOverview Page

    Scenario: TC02  Verify your information with empty fields
      When user clicks on checkout
      Then user should be redirected to checkout page
      And clicks on Continue
      Then error message "Error: First Name is required" should be displayed

  Scenario: TC03  Verify your information with only firstname
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters only firstname
    And clicks on Continue
    Then error message "Error: Last Name is required" should be displayed

  Scenario: TC04  Verify your information with only lastname
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters only lastname
    And clicks on Continue
    Then error message "Error: First Name is required" should be displayed

    Scenario: TC05 Verify your information with only postalcode
      When user clicks on checkout
      Then user should be redirected to checkout page
      When user enters only postalcode
      And clicks on Continue
      Then error message "Error: First Name is required" should be displayed

  Scenario: TC06 Verify your information with firstname and lastname and leaving postalcode empty
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters only firstname and lastname
    And clicks on Continue
    Then error message "Error: Postal Code is required" should be displayed

  Scenario: TC07 Verify your information with firstname and postalcode and leaving lastname empty
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters only firstname and postalcode
    And clicks on Continue
    Then error message "Error: Last Name is required" should be displayed


  Scenario: TC08 Verify your information with lastname and postalcode and leaving firstname empty
    When user clicks on checkout
    Then user should be redirected to checkout page
    When user enters only lastname and postalcode
    And clicks on Continue
    Then error message "Error: First Name is required" should be displayed

