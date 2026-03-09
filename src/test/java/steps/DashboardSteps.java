package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class DashboardSteps extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("doctor goes to sign in page")
    public void doctor_goes_to_sign_in_page() {
        driver.get(ConfigurationReader.getProperty("loginURL"));
    }

    @When("doctor enters email {string}")
    public void doctor_enters_email(String userName) {
        waitAndSendKeys(loginPage.email, userName);
    }

    @When("doctor enters password {string}")
    public void doctor_enters_password(String password) {
        waitAndSendKeys(loginPage.password, password);
    }

    @When("doctor clicks on sign in button")
    public void doctor_clicks_on_sign_in_button() {
        waitAndClick(loginPage.loginBtn);
    }

    @Then("doctor should see the dashboard page")
    public void doctor_should_see_the_dashboard_page() {
        waitUntilVisible(20, dashboardPage.doctorsWelcomeSign);
        Assertions.assertTrue(dashboardPage.doctorsWelcomeSign.isDisplayed());
    }

    @Then("doctor should see the table with patients")
    public void doctor_should_see_the_table_with_patients() {
        waitUntilVisible(20, dashboardPage.doctorsWelcomeSign);
        scrollIntoViewJS(dashboardPage.patientsTable);
        Assertions.assertTrue(dashboardPage.patientsTable.isDisplayed());
    }

    @Then("doctor should see info about appointments on graphic")
    public void doctor_should_see_info_about_appointments_on_graphic() {
        waitUntilVisible(20, dashboardPage.graphColumn);
        hoverOver(dashboardPage.graphColumn);
        Assertions.assertTrue(dashboardPage.chartLabel.isDisplayed());
    }

    @When("doctor clicks on patient")
    public void doctor_clicks_on_patient() {
        waitUntilVisible(20, dashboardPage.doctorsWelcomeSign);
        scrollIntoViewJS(dashboardPage.patientsTable);
        dashboardPage.patient.click();
    }

    @Then("doctor should see patients profile")
    public void doctor_should_see_patients_profile() {
        waitUntilVisible(20, dashboardPage.patientProfileBtn);
        Assertions.assertTrue(dashboardPage.patientProfileBtn.isDisplayed());
    }
}
