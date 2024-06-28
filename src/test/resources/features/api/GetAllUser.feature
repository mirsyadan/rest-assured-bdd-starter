Feature: Get all user
  As a admin
  I want to get all user
  So that I can see all user

  #positive
  Scenario: As a admin I can get all user with valid endpoint and method
    Given I set valid API endpoint and method
    When I send a request to get all user
    Then I receive the status code 200 OK
    And I get all user with valid

  #negative
  Scenario: As a admin I can't get all user with valid endpoint and wrong method
    Given I set valid API endpoint and wrong method
    When I send request to get all user with invalid method
    Then I receive the status code 404 not found