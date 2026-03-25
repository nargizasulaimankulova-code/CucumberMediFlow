Feature: test patient creation
  Background:
    Given base URL

    #using pojo
  @createPatient
Scenario Outline: verify user can create patient 201
  Given "<userType>" has valid authorization
  When user hits POST "/api-patients"
  Then verify status code is 201
  Examples:
    | userType       |
    | doctor         |
    | nurse          |
    | office manager |

  @createPatient
  Scenario Outline: verify user cannot create patient with missing required filed 400
    Given "<userType>" has valid authorization
    When user hits POST "/api-patients" with missing required filed
    Then verify status code is 400
    Examples:
      | userType       |
      | doctor         |
      | nurse          |
      | office manager |

  @createPatient
  Scenario Outline: verify user cannot create patient with invalid authorization 401
    Given "<userType>" has invalid authorization
    When user hits POST "/api-patients"
    Then verify status code is 401
    Examples:
      | userType       |
      | doctor         |
      | nurse          |
      | office manager |