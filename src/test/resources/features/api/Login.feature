Feature: Login
  As a User
  I want to login
  So that I can use the App

  #positive
  Scenario: Login with valid email and password
    Given I set the API endpoint for login
    When I submit a request to the API endpoint with a valid email and password
    And I should receive a status code of 200
    Then I should receive a token indicating successful login

  #negative
  Scenario: Login with email and password fields is empty
    Given I set the API endpoint for login
    When I send a request to the API endpoint with a empty data
    Then I should receive a status code of 400 Bad Request