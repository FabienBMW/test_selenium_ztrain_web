@OF-901_OF-831_OF-906_OF-903
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

  Scenario Outline: Payment validation
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When he selects <product>
    And he fills in the quantity of the product to add via icons - and +
    And he clicks on add to cart
    And he clicks on cart icon
    And User clicks on order button
    And User fills fields with <card number>, <expired date>, <cvc> and <adresse de livraison>
    And User sends the form
    Then A validation confirmation message should appear on the screen

    Examples:
      | email                             | password | product                      | card number         | expired date | cvc | adresse de livraison |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | Chaise de Bureau Ergonomique | 4242 4242 4242 4242 | 12 / 23      | 520 | 204 Rue Manga-bell   |

  Scenario Outline: Test fields required for payment
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When he selects <product>
    And he fills in the quantity of the product to add via icons - and +
    And he clicks on add to cart
    And he clicks on cart icon
    And User clicks on order button
    And User sends the form
    Then A required fields error message should appear under the fields "* Numéro de carte invalide" "* Veuillez spécifier l'adresse de livraison"

    Examples:
      | email                             | password | product                      | card                       | address                                     |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | Chaussures Hommes de Ville | * Numéro de carte invalide | * Veuillez spécifier l'adresse de livraison |