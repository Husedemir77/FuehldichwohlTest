Feature: Login, Fühldichfit and Delete Products Functionality

  @SmokeTest
  Scenario: Login with valid username and password
    Given Navigate to FuehldichWohl
    When Enter username and password and click
    When Click an fühldichfit and check to text
    Then RandomToFitsAndRandomToProduct
    And AddToBagAndCheckout
    And Delete the first product

