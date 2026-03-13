
Feature: Prescriptions page functionality

  Background: doctor sign in
    Given doctor goes to sign in page
    When doctor enters email "dr.chen@mediflow.com"
    And doctor enters password "Test@1234"
    And doctor clicks on sign in button
    And doctor clicks prescription tab
  @smoke
    Scenario: doctor can search prescription by medication
      When doctor enters medication "Amoxi" in search bar
      Then doctor should see prescriptions results

    Scenario: doctor can filter prescriptions by status
      When doctor clicks prescription status dropdown
      Then doctor should see status dropdown options
  @smoke
    Scenario: doctor can create new prescription form
      When doctor clicks on new prescription button
      And doctor selects patient name
      And doctor enters medication name "Amoxicillin"
      And doctor enters dosage "500mg"
      And doctor enters duration "30"
      And doctor selects frequency "Twice daily"
      And doctor enters instructions "Take with food"
      And doctor clicks create prescription button
      Then doctor should return to prescriptions page