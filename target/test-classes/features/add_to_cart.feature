@OF-831
  Feature: As a customer, I want to add products to cart, so that I could make payment
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
        | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | JVC, Caque Supra-aural Pliable | Votre panier à été mis à jour |