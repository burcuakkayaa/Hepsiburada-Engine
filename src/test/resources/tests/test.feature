Feature: Hepsiburada E2E Test Cases

  @chrome
  Scenario: Hepsiburada - Happy Path - Adding a product to the basket
    Given user visits Hepsiburada.com
    And user searches a product with "çanta"
    Then user blabla
