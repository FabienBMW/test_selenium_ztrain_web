@login
  Feature: As a Z-Train client I want to login so that I could access to online store
    Scenario Outline: Perform login with valid credentials
      Given user is at login page
      When user is logging-in with <email> <password>
      Then he should be redirected to the home page

      Examples:
        | email                             | password     |
        | sehajpreet2.nicholi@orperfect.com | hqqps2J$     |