Feature: Creating account
  as user i want create an account

  Scenario: Creating a new account
    Given user haven't account
    When user give username and password
    Then there is a new account with credentials
