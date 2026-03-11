@regression
Feature: Appointment page functionality

  Background: doctor sign in
    Given doctor goes to sign in page
    When doctor enters email "dr.chen@mediflow.com"
    And doctor enters password "Test@1234"
    And doctor clicks on sign in button

  Scenario: doctor should be able to schedule the appointment
    When doctor navigates to the appointment page
    And clicks on the schedule appointment button
    And filling out the form
    And clicks on the schedule button
    Then doctor should see appointment scheduled