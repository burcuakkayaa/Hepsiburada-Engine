Feature: Hepsiburada E2E Test Cases

  @chrome
  Scenario: Hepsiburada - Happy Path - Adding different seller's products
    Given user visits hepsiburada.com
    When user searches "bot"
    And user selects 1 product from product list
    And user selects different seller's of the product
    And user clicks Basket button
    Then user see that there are selected products at the Cart Page

