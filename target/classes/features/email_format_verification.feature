@OF-1014
Feature: login

  Scenario Outline: Email format
    Given user is at login page
    And user fills the email's field with value <email>
    When user clicks on submit button
    Then An error appears to report invalid email syntax <message>
    Examples:
      | email             | message                          |
      | 237pk69@gmail | Le format de l'email est invalid |