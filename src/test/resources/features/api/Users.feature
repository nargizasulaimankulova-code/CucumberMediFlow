Feature: user endpoints related tests

  Background:
    Given base URL

  @listOfUsers
  Scenario Outline: verify authorized users can get list of staff users
    Given "<userType>" has valid authorization
    When user hits GET "/api-users"
    Then verify status code is 200
    Examples:
      | userType       |
      | office manager |
      | admin          |

  Scenario Outline: verify unauthorized users can't get list of staff users
    Given "<userType>" has invalid authorization
    When user hits GET "/api-users"
    Then verify status code is 403
    Examples:
      | userType |
      | doctor   |
      | nurse    |

  Scenario: verify unauthenticated user can't get list of staff users
    Given user has invalid authorization
    When user hits GET "/api-users"
    Then verify status code is 401