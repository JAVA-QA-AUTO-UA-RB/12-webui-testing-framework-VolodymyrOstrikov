@ui @checkboxes
Feature: Checkboxes page
  As a user
  I want to interact with checkboxes
  So that I can verify their state

  Scenario: Toggle checkboxes
    Given I open the home page
    When I navigate to "Checkboxes" page
    And I toggle the first checkbox
    Then the first checkbox should be checked
    And I toggle the second checkbox
    Then the second checkbox should not be checked