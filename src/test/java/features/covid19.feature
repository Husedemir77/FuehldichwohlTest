Feature: Covid-19 page functinality

  Scenario: US04_TC01 The unter menus in the page should be visible.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then  Hover on Covid menu
    And   check the Covid menu link


  Scenario: US05_TC01 User should be able to add the product to Cart.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on Covid menu
    And Covid menu random add a Product in den Warenkorb
    Then check in den Warenkorb a product


  Scenario: US05_TC02 If the product is In Stock user should be able to change the quantity
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on Covid menu
    And Covid menu random add a Product in den Warenkorb
    Then change the quantity in der Warenkorb
    And check pries and zwischensumme


  Scenario: US05_TC02 CovidMenu Selected product should be able to deleted.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on Covid menu
    And Covid menu random add a Product in den Warenkorb
    And go to Warenkorb
    Then remove the product
    And check the not
