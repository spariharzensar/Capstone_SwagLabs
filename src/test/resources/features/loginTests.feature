@login

Feature: Login Page Functionality

  Scenario: TC01 Verify login with valid credentials
    Given user is on the login page
    When the user enters username and password
    And clicks on the login button
    Then user should be redirected to the inventory page

  Scenario: TC02 Verify login with invalid credentials
    Given user is on the login page
    When user enters invalid username and password
    And clicks on the login button
    Then error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  Scenario: TC03 Verify login with empty fields
    Given user is on the login page
    And clicks on the login button
    Then error message "Epic sadface: Username is required" should be displayed

  Scenario: TC04 Verify login with only username
    Given user is on the login page
    When user enters username and leaves password empty
    And clicks on the login button
    Then error message "Epic sadface: Password is required" should be displayed

  Scenario: TC05 Verify locked user login
    Given user is on the login page
    When user enters locked user credentials
    And clicks on the login button
    Then error message "Epic sadface: Sorry, this user has been locked out." should be displayed

#sindhu
  Scenario: TC06 Verify whether the user is logged out properly
    Then user should be redirected to the inventory page
    When user clicks on the menu button on the left
    Then user clicks on the logout button and successfully loggedout
