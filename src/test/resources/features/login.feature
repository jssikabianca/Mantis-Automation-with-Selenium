# language: en
Feature: User Login
  @smoke-test
  Scenario: Successful login
    Given the user is on the login page
    When the user enters a valid username and click the "Login" button
    And the user enters a valid password and click the "Login" button
    Then the user should be redirected to the dashboard page

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username and click the "Login" button
    And the user enters an invalid password and click the "Login" button
    Then the user should see an error message

  Scenario: Unsuccessful login with missing credentials
    Given the user is on the login page
    When the user enters a valid username and click the "Login" button
    And the user clicks the "Login" button without entering credentials
    Then the user should see an error message