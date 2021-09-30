Feature: Alle Produkte Page product functionality
@SmokeTest
  Scenario: 1-Check visible  all product images of the Alle Produkte page
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then all product images should be visible

@SmokeTest
  Scenario: 2-Check clickable  all product images of the Alle Produkte page
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then all product links should be properly defined


  Scenario: 3-Check all product images basket button of the Alle Produkte page
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then all product should be properly defined,when click to basket button


  Scenario: 4-Checks all product images magnification of the Alle Produkte page
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then all product images should be properly defined,when click to images magnification button

  Scenario: 5-Check product purchase
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then user can navigate to the product purchase page
    Then user click to lieferung checkbox
    Then user should fill to the Rechnungdetails field
      | Vorname     | Tutus Test              |
      | Nachname    | User                    |
      | Firmenname  | User                    |
      | Land        | Deutschland             |
      | Strasse     | User                    |
      | Wohnung     | User                    |
      | Posleitzahl | 12345                   |
      | Stadt       | User                    |
      | Telefon     | 12345                   |
      | EMail       | testuser@tutusmedia.com |


    Then user should fill to the Lieferungdetails field
      | Vorname2     | Tutus Test  |
      | Nachname2    | User        |
      | Firmenname2  | User        |
      | Land2        | Deutschland |
      | Strasse2     | User        |
      | Wohnung2     | User        |
      | Posleitzahl2 | 12345       |
      | Stadt2       | User        |
      | Anmerkungen  | User        |

  Scenario: 6-Check warenkorb update
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then user should be able to update the Warenkorb
    When user navigate to Alle Produkte Page
    Then user should be able to send the quantity in the warenkorb

  Scenario: 7-Check Warenkorb Summe
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then user should be able to check the summe in Warenkorb

  Scenario: 8-Check Warenkorb Summe
    Given user on Home Page
    When user navigate to Alle Produkte Page
    Then user should be able to add bewertungen
      | Kommentar | Tutus Test              |
      | Name      | User                    |
      | Email     | testuser@tutusmedia.com |
      | Website   | Fuehldichwohl24         |
