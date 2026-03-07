# Codewise Clinic Portal – Test Automation Framework

## Overview
This project is a Test Automation Framework built using Java, Selenium WebDriver, Cucumber (BDD), and JUnit.

The framework automates UI testing for the Codewise Clinic Portal web application.

The framework follows Page Object Model (POM) and Behavior Driven Development (BDD) practices to make tests readable, maintainable, and scalable.

Application Under Test:
https://codewise-clinic-portal.lovable.app/login

## Tech Stack

Java  
Selenium WebDriver  
Cucumber (BDD)  
JUnit  
Maven  
WebDriverManager  
Page Object Model (POM)

## Project Structure

src
└── test
├── java
│    ├── runners
│    │     └── TestRunner.java
│    │
│    ├── stepdefinitions
│    │     └── LoginSteps.java
│    │
│    ├── pages
│    │     └── LoginPage.java
│    │
│    └── utils
│          └── Driver.java
│
└── resources
└── features
└── login.feature

## Test Approach

The framework uses BDD (Behavior Driven Development) with Cucumber.

Example Scenario:

Feature: Login functionality

Scenario: User logs into the clinic portal
Given user is on login page
When user enters valid email and password
And user clicks login button
Then user should see dashboard

## Running Tests

Run tests using the Cucumber Test Runner:

TestRunner.java

Or run with Maven:

mvn test

## Test Reports

After execution, a report will be generated in:

target/cucumber-report.html

The report contains:
- Test results
- Passed and failed scenarios
- Execution details

## Framework Features

Page Object Model design  
Cucumber BDD implementation  
Selenium WebDriver UI automation  
Maven dependency management  
Easy test maintenance  
Scalable framework structure

## Future Improvements

Add Hooks (Before and After scenarios)  
Add ConfigReader for environment configuration  
Implement reusable wait utilities  
Add screenshot on test failure  
Integrate Extent Reports  
Enable parallel test execution

## Author

Automation QA Engineer  
Java | Selenium | Cucumber | Test Automation