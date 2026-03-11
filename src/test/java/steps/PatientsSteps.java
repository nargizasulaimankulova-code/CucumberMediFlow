package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPages;
import pages.PatientsPage;
import utils.BaseUI;
import utils.Driver;

import java.util.Random;

public class PatientsSteps extends BaseUI {
    WebDriver driver = Driver.getDriver();
    PatientsPage patientsPage = new PatientsPage();
    CommonPages commonPages = new CommonPages();
    Faker faker = new Faker();

    Random random = new Random();


    @Given("doctor is logged into the clinic portal")
    public void doctor_is_logged_into_the_clinic_portal() {
     waitUntilVisible(20,patientsPage.mediFlowSign);
     String text = patientsPage.mediFlowSign.getText();
     Assertions.assertEquals("MediFlow",text);

    }
    @Given("doctor navigates to the patients page")
    public void doctor_navigates_to_the_patients_page() {
        waitUntilVisible(10,commonPages.patients);
      waitAndClick(commonPages.patients);
    }

    @When("doctor searches for patients")
    public void doctor_searches_for_patients() {
waitUntilVisible(10,patientsPage.searchPatientInput);
patientsPage.searchPatientInput.sendKeys("a");

    }
    @When("doctor selects the first patient from the list")
    public void doctor_selects_a_random_patient_from_search_results() {
        if (!patientsPage.listOfPatients.isEmpty()){
            waitAndClick(patientsPage.listOfPatients.get(0));
        }
        }
    @When("doctor clicks the View button")
    public void doctor_clicks_the_view_button() {
      patientsPage.clickFirstViewPatient();

    }
    @Then("patient profile page should be displayed")
    public void patient_profile_page_should_be_displayed() {
        waitUntilVisible(20,patientsPage.patentName);

        Assertions.assertTrue(patientsPage.patentName.isDisplayed());

    }

    @When("doctor clicks the Edit button")
    public void doctor_clicks_the_edit_button() {
        jsClick(patientsPage.editBtn);

    }

    @When("doctor updates the patient phone number")
    public void doctor_updates_the_patient_phone_number() {
      waitAndSendKeys(patientsPage.phoneNumber,faker.phoneNumber().cellPhone());
    }

    @When("doctor clicks the Save button")
    public void doctor_clicks_the_save_button() {
waitAndClick(patientsPage.saveBtn);

    }
    @Then("patient profile should be updated successfully")
    public void patient_profile_should_be_updated_successfully() {
    waitUntilVisible(10,patientsPage.successAlert);
    Assertions.assertTrue(patientsPage.successAlert.isDisplayed());
    }

}

