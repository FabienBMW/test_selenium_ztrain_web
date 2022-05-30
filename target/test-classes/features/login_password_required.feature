@login_password_required.OF-807
Feature: As a customer I want to login without fill the fields so that I could see error messages

  Scenario Outline: Error messages on the login page
    Given user is at login page
    When User clicks on connexion button without filling in the login and password fields
    Then User should see an error message below the login and password fields <email> <password>

    Examples:
      | email                            |
      | Le format de l'email est invalid |