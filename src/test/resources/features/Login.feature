@regression
Feature: all login related test scenarios

  Background:
    Given user goes to sign in page
@smoke
  Scenario: verify doctor can login successfully
    When user enters credentials "validUserName" and "validPassword"
    Then verify user signed in successfully

  Scenario:
    When user enters credentials "invalidUserName" and "invalidPassword"
    Then verify user failed to sign in

@smoke
  Scenario Outline: verify all types of users can login
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on sign in button
    Then verify user signed in successfully
    Examples:
      | username                  | password  |
      | dr.chen@mediflow.com      | Test@1234 |
      | mgr.wilson@mediflow.com   | Test@1234 |
      | nurse.garcia@mediflow.com | Test@1234 |


  Scenario Outline: verify all types of users fail to login with invalid credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on sign in button
    Then verify user failed to sign in
    Examples:
      | username                | password  |
      | dr@mediflow.com         | Test@1234 |
      | mgr.wilson@mediflow.com | TEST@1234 |
      |                         | Test@1234 |
      | mgr.wilson@mediflow.com |           |
      |                         |           |