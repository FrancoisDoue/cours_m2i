Feature: Ordering products

  Scenario: User can add product to order
    Given user create a new empty order
    And user must be logged
    When user select a product
    Then product is added to his order

  Scenario: User can remove product from order
    Given user have an order with products
    And user must be logged
    When user select a product from order
    Then product is removed from order
    And order cost is updated

#  Scenario: User can validate order
#    Given user have un order with product
#    And user must be logged
#    When user valid order
#    Then Order is validate
#    And user receive a confirmation message