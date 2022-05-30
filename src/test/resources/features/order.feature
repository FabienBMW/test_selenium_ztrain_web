@OF-901
Feature: As a customer, I want to add products to cart, so that I could make payment

  Scenario Outline: Order pop up
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When he selects <product>
    And he fills in the quantity of the product to add via icons - and +
    And he clicks on add to cart
    And he clicks on cart icon
    And User clicks on order button
    Then The order validation pop-up should appear

    Examples:
      | email                             | password | product              |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | I-phone PRO 256 NOIR |