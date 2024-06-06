Feature: Create an account and login
  Scenario: User create an account for making orders
    Given User access to a register form
    When User give mail, name and password
    Then Account is creates
    And User have a success message

  Scenario: User cannot create account
    Given User access to a register form
    When User give an existing mail, name and password
    Then Account is not created
    And User have an error message


#Feature: Command Ordering
#
#as a customer i want to make a command form someone
#
#  Scenario: Creation of an empty Command
#    Given Customer who whant to command for Someone
#    When a Command is make form Someone
#    Then there is no product in the Command
#    And the command come from Customer