@login
Feature: Login Page Functionality

  Scenario: Verify login with valid credentials
    Given user is on the login page
    When user enters username and password
    And clicks on the login button
    Then user should be redirected to the inventory page

  Scenario: Verify login with invalid credentials
    Given user is on the login page
    When user enters invalid username and password
    And clicks on the login button
    Then error message "Epic sadface: Username and password do not match any user in this service" should be displayed

  Scenario: Verify login with empty fields
    Given user is on the login page
    And clicks on the login button
    Then error message "Epic sadface: Username is required" should be displayed

  Scenario: Verify login with only username
    Given user is on the login page
    When user enters username and leaves password empty
    And clicks on the login button
    Then error message "Epic sadface: Password is required" should be displayed

  Scenario: Verify locked user login
    Given user is on the login page
    When user enters locked user credentials
    And clicks on the login button
    Then error message "Epic sadface: Sorry, this user has been locked out." should be displayed