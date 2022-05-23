@logout.OF-840
Feature:

  Scenario Outline:Given user is at login page
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When User clicks on Account icon
    And User clicks on disconnect
    Then User should be logged out

    Examples:
      | email                             | password |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ |