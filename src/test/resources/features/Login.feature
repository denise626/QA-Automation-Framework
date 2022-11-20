Feature: Login feature

  Scenario: Login Success

    Given I open Login Page
    When I enter email "denise626@hotmail.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in

