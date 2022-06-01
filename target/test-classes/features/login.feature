@login_OF-1014_OF-807_OF-806
Feature: As a Z-Train client I want to login so that I could access to online store

  Scenario Outline: Perform login with valid credentials
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page

    Examples:
      | email                             | password |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ |

  Scenario Outline: Email format
    Given user is at login page
    And user fills the email's field with value <email>
    When user clicks on submit button
    Then An error appears to report invalid email syntax <message>
    Examples:
      | email         | message                          |
      | 237pk69@gmail | Le format de l'email est invalid |

  Scenario Outline: Error messages on the login page
    Given user is at login page
    When User clicks on connexion button without filling in the login and password fields
    Then User should see an error message below the login and password fields <email> <password>

    Examples:
      | email                            |
      | Le format de l'email est invalid |

  Scenario:
    Given user is at login page
    When user fill in the password field "a123456"
    And User clicks on the display password button to the right of the password field
    Then The password is displayed in clear