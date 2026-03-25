Feature: test patient creation
  Background:
    Given base URL

    #using pojo
  @createPatient
Scenario Outline: verify user can create patient
  Given "<userType>" has valid authorization
  When user hits POST "/api-patients"
  Then verify status code is 201
  Examples:
    | userType       |
    | doctor         |
    | nurse          |
    | office manager |
