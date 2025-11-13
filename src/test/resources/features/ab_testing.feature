@ui @ab
Feature: A/B Testing page
  As a visitor
  I want to open A/B Testing page
  So that I can verify it's loaded correctly

  @smoke
  Scenario: Verify A/B Testing page loads successfully
    Given I open the home page
    When I navigate to "A/B Testing" page
    Then the page URL should contain "/abtest"
    And the header should contain "A/B Test Variation 1"