
Feature: patient page related test cases

  Background:
    Given user goes to sign in page
    And user enters username "dr.chen@mediflow.com"
    And user enters password "Test@1234"
    And user clicks on sign in button

#    The view page in UI does not always open/load -> which will cause both below scenarios to Fail
  Scenario: Doctor can view random patient profile from search results
    Given doctor is logged into the clinic portal
    And doctor navigates to the patients page
    When doctor searches for patients
    And doctor selects the first patient from the list
    And doctor clicks the View button
    Then patient profile page should be displayed

@smoke
  Scenario: Doctor can edit patient profile
    Given doctor is logged into the clinic portal
    And doctor navigates to the patients page
    When doctor selects the first patient from the list
    And doctor clicks the View button
    And doctor clicks the Edit button
    And doctor updates the patient phone number
    And doctor clicks the Save button
    Then patient profile should be updated successfully
