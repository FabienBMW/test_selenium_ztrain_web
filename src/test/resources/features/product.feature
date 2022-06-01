@OF-1015
Feature: As a customer, I want to access the shop, so that I could see products informations

  Scenario Outline: Product information
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When User selects <article>
    Then Spawn a popup on the page with description of the <article> and the <precise_price>

    Examples:
      | article              | precise_price | email                             | password |
      | Yucca Elephantipes   | 9.99          | sehajpreet2.nicholi@orperfect.com | hqqps2J$ |
      | I-phone PRO 256 NOIR | 1259.02       | sehajpreet2.nicholi@orperfect.com | hqqps2J$ |