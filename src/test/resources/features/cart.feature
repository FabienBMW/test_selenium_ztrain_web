@OF-902_OF-1191
  Feature:
    Scenario Outline: Add product to cart
      Given user is at login page
      When user is logging-in with <email> <password>
      Then he should be redirected to the home page
      When he selects <product>
      And he fills in the quantity of the product to add via icons - and +
      And he clicks on add to cart
      Then he observes a pop pop which indicates the following message <message>

      Examples:
        | email                             | password | product                        | message                       |
        | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | JVC, Caque Supra-aural Pliable | Votre panier à été mis à jour |

    Scenario Outline: Produit en promotion
      Given user is at login page
      When user is logging-in with <email> <password>
      Then he should be redirected to the home page
      When The user sees the prices <old_price> and <new_price> of a product <product> on promotion
      And he clicks on add to cart
      And he observes a pop pop which indicates the following message <message>
      And he clicks on cart icon
      Then The user must see the amount of <product> in the basket equal to the price of the promotion <new_price>

      Examples:
        | email                             | password | product                      | new_price | old_price | message                       |
        | sehajpreet2.nicholi@orperfect.com | hqqps2J$ | Ampoule Vecteur Incandescent | 27.89     | 30.99     | Votre panier à été mis à jour |

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