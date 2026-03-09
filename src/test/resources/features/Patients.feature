@regression @many
Feature: patient page related test cases

  Background:
    Given user goes to sign in page
    And user enters username "dr.chen@mediflow.com"
    And user enters password "Test@1234"
    And user clicks on sign in button

  Scenario Outline: Doctor can view patient profile from search results
    Given doctor is logged into the clinic portal
    And doctor navigates to the patients page
    When doctor enters "<patientName>" into the patient search field
    And doctor clicks the View button for patient "<patientName>"
    Then patient profile page for "<patientName>" should be displayed

    Examples:
      | patientName   |
      | Donald Trump  |
      | Olga Anderson |
      | James Brown |
