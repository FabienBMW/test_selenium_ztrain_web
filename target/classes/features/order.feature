@order_button_OF-901_OF-906_OF-1015_OF-831
Feature: As a customer, I want to add products to cart, so that I could make payment

  Scenario Outline: Product information
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When User selects <article>
    Then Spawn a popup on the page with description of the <article> and the <precise_price>

    Examples:
      | article                      | precise_price | email                             | password |
      | Chaise de Bureau Ergonomique | 60.05         | sehajpreet2.nicholi@orperfect.com | hqqps2J$ |
      | I-phone PRO 256 NOIR         | 1259.02       | sehajpreet2.nicholi@orperfect.com | hqqps2J$ |

  Scenario Outline: Add product to cart
    Given user is at login page
    When user is logging-in with <email> <password>
    Then he should be redirected to the home page
    When he selects <product>
    And he fills in the quantity of the product to add via icons - and +
    And he clicks on add to cart
    Then then we observe a pop pop which indicates the following message <message>

    Examples:
      | email                             | password | product                        | message                       |
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | JVC, Caque Supra-aural Pliable | votre panier à été mis à jour |

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
      | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | Ampoule Vecteur Incandescent | 4242 4242 4242 4242 | 12 / 23      | 520 | 204 Rue Manga-bell   |