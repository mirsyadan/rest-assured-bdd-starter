Feature: Get all cart
  As a admin
  I want to get all cart
  So that I can see all cart

  #positive
  Scenario: As a admin I can get all cart with valid endpoint and method
    Given I set the valid endpoint and method
    When I send a request to get all cart
    Then I receive in status code 200 OK
    And I get all cart with valid

  #negative
  Scenario: As a admin I can't get all cart with valid endpoint and wrong method
    Given I set the valid endpoint and wrong method
    When I send request to get all cart with invalid method
    Then I receive in status code 404 not found