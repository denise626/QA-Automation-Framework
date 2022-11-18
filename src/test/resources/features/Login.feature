Feature: Login feature

  Scenario: Login Success
    Given I open the browser
    And I open Login page
    When I enter email "denise626@hotmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in