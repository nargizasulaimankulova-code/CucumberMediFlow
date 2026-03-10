@regression
Feature: Dashboard page functionality

  Background: doctor sign in
    Given doctor goes to sign in page
    When doctor enters email "dr.chen@mediflow.com"
    And doctor enters password "Test@1234"
    And doctor clicks on sign in button

  Scenario: doctor can see the dashboard page
    Then doctor should see the dashboard page

  Scenario: doctor can see the chart
    Then doctor should see the chart

  Scenario: doctor can see the table with patients
    Then doctor should see the table with patients

  Scenario: doctor can see current patient info
    When doctor clicks on patient
    Then doctor should see patients profile
@smoke
    Scenario: doctor can see active patients info
      Then doctor should see active patients info