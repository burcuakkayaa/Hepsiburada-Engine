Feature: Hepsiburada E2E Test Cases

  @chrome
  Scenario: Hepsiburada - Happy Path - Adding a product to the basket
    Given user visits Hepsiburada.com
    When user searches a product with "çanta"
    And user selects 2 different products from different sellers
    And user clicks Basket button
    Then user see that there are selected products at the Cart Page

