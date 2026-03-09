Feature: all login related test scenarios

  Background:
    Given user goes to sign in page

  Scenario Outline: verify all types of users can login
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on sign in button
    Then verify user signed in successfully
    Examples:
      | username                      | password  |
      | dr.chen@mediflow.com          | Test@1234 |
      | nurse.garcia@mediflow.com     | Test@1234 |
      | mgr.wilson@mediflow.com       | Test@1234 |
      | admin.superadmin@mediflow.com | Test@1234 |

  Scenario Outline: verify all types of users fail to login with invalid credentials
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on sign in button
    Then verify user failed to sing in
    Examples:
      | username                | password  |
      | dr@mediflow.com         | Test@1234 |
      | garcia@mediflow.com     | TEST@1234 |
      |                         | Tst@1234  |
      | wilsonasda@mediflow.com |           |
      |                         |           |