@OF-906
  Feature: As a customer, I want to add products to cart, so that I could make payment
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