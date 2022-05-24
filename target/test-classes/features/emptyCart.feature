@empty_cart_OF-902
Feature: As a customer, I want to add products to cart so that I could empty the cart

  Scenario Outline: Add product to cart and empty the cart
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When he selects <product>
    And he fills in the quantity of the product to add via icons - and +
    And he clicks on add to cart
    When user clicks again on cart icon
    And he clicks on empty cart button
    Then the cart should be empty

    Examples:
      | email                             | password | product                             |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | Enceinte Bluetooth portable robuste |