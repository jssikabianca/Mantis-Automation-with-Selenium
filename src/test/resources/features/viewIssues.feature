# language: en
Feature: View Created Task

  @smoke-test
  Scenario: View a created issue in the issue list
    Given that I am logged into the application
    When I create a new task
    Then I should see the issue with the main information