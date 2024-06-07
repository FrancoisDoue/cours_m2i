Feature: Create account and connect

  Scenario: Create an account with valid credentials
    Given : user gives valid credentials
    When : application registering user with success
    Then : account is created

#  Scenario: Account is not created because of invalid credentials
#    Given : user gives invalid credentials
#    When : account is not created
#    Then : user have an error message
#    And : Existing user exception is raised

  Scenario: Login to an account with valid credentials
    Given : user gives valid credentials "user1@mail.fr" "password" for connection
    When : application connect with success
    Then : user is logged

#  Scenario: User cannot connect to his account because of invalid credentials
#    Given : user gives invalid credentials for connection
#    When : application fail to connect
#    Then : InvalidCredentials exception is raised
