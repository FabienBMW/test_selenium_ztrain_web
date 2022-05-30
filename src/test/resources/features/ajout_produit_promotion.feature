@OF-1191
Feature: En tant que utilisateur connecté sur la page d’accueil,En ajoutant un produit en promotion au panier, je dois voir afficher un montant relatif à la promotion

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