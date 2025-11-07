@ui @login
Feature: Login page
  As a user
  I want to log in to the secure area
  So that I can access restricted content

  @regression
  Scenario: Successful login
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "tomsmith" and password "SuperSecretPassword!"
    Then I should see a success message containing "You logged into a secure area!"
    And I should be able to logout

  @regression
  Scenario: Invalid login attempt
    Given I open the home page
    When I navigate to "Form Authentication" page
    And I login with username "wrong" and password "wrong"
    Then I should see an error message containing "Your username is invalid!"