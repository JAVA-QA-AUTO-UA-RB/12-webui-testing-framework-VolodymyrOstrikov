@ui @elements
Feature: Add/Remove Elements page
  As a user
  I want to add and remove elements
  So that I can test element management

  Scenario: Add and remove elements successfully
    Given I open the home page
    When I navigate to "Add/Remove Elements" page
    And I add 3 elements
    Then I should see 3 delete buttons
    When I remove all elements
    Then I should see 0 delete buttons