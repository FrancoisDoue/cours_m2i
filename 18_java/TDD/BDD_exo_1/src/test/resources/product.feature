Feature: Navigate in products

  Scenario: User can search product
    Given there is product in list
    When user type a word
    Then user receive a list of products
    And products match with word

  Scenario: User cas search by categories
    Given there is a list of categories
    When user select a category
    Then User receive a list of products matching category