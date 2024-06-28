Feature: Get all product
  As a admin
  I want to get all product
  So that I can see all product

  #positive
  Scenario: As a admin I can get all product with valid endpoint and method
    Given I set valid endpoint and method
    When I send a request to get all product
    Then I receive on status code 200 OK
    And I get all product with valid

  #negative
  Scenario: As a admin I can't get all product with valid endpoint and wrong method
    Given I set valid endpoint and wrong method
    When I send request to get all product with invalid method
    Then I receive on status code 404 not found