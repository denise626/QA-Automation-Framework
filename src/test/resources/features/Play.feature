Feature: Playing a song feature

  Scenario: Playing a song is success

    Given I am logged in
    When I click on song link
    And double click on song to play
    Then song will play
