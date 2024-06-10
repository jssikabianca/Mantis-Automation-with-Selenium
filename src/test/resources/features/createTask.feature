# language: en
Feature: Manage tasks

  Scenario:  Access the task creation functionality from the home page
    Given the user is logged into the application
    When the user clicks the Report Issue button
    Then the user should be redirected to the new task registration page

  @smoke-test
  Scenario:  Create new task
    Given the user is logged into the application
    And the user is on the create new task page
    When the user fills out the new task form
    And click on the submit issue
    Then the user should see a success message confirming the task creation
    And the view Issue details appear in the screen

  Scenario: Create new task with missing required fields
    Given the user is on the create new task page
    And click on the submit issue
    Then the user should remain on the create new task page
