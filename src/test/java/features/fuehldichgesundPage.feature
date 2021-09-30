Feature: US-1 User should be able to use fühldichgesund Page functionality.

  @Regression
  Scenario: US01_TC01 The unter menus in the page should be visible.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then  Hover on fuehldichgesund menu
    And   check the menu link


  @Regression
  Scenario: US01_TC03 All links should have destination and work properly.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fuehldichgesund menu
    And Hover fuehldichgesundMenus und check


  @Regression
  Scenario: US01_TC04 Every product should have image, name and price.
    Given Navigate to as "https://fuehldichwohl24.de/"
    And Hover on fuehldichgesund menu
    Then go to subMenus und Product check


  @SmokeTest
  Scenario: US02_TC01 User should be able to add the product to Cart.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fuehldichgesund menu
    And Random go to submenus und random add a Product in den Warenkorb
    Then check in den Warenkorb a product



  Scenario: US02_TC02 If the product is In Stock user should be able to change the quantity
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fuehldichgesund menu
    And Random go to submenus und random add a Product in den Warenkorb
    Then change the quantity in der Warenkorb
    Then check pries and zwischensumme


  @SmokeTest
  Scenario: US03_TC02 Selected product should be able to deleted.
    Given Navigate to as "https://fuehldichwohl24.de/"
    Then Hover on fuehldichgesund menu
    And Random go to submenus und random add a Product in den Warenkorb
    And go to Warenkorb
    Then remove the product
    Then check the not





















