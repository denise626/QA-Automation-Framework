Feature: Login feature

  Background:
    Given I open Login Page
    Given I open Login Page
    When I enter email "denise626@hotmail.com"
    And I enter password "te$t$tudent"
    And I submit


  Scenario: Login Success
    Then I am logged in HomePage

  Scenario: Creating playlist is successful
    When I click on create a new playlist
    Then create playlist is displayed

  Scenario: Playing a song is success
    When I click on song link
    And double click on song to play
    Then song will play

