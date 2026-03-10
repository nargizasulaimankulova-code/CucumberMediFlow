package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.PrescriptionsPages;
import utils.BaseUI;
import utils.Driver;

public class PrescriptionsSteps extends BaseUI {

    public PrescriptionsPages prescriptionsPages = new PrescriptionsPages();

    @And("doctor clicks prescription tab")
    public  void doctor_clicks_prescription_tab(){
        waitAndClick(prescriptionsPages.prescriptionTab);

    }

    @When("doctor enters medication {string} in search bar")
    public void doctor_enters_medication_Amoxi_in_search_bar(String medication){
        waitAndSendKeys(prescriptionsPages.searchBar, medication);
    }

    @Then("doctor should see prescriptions results")
    public void doctor_should_see_prescriptions_results(){
        waitUntilVisible(10, prescriptionsPages.prescriptionTable);
        Assertions.assertTrue(prescriptionsPages.prescriptionTable.getText().contains("Amoxi"));
    }


    @When("doctor clicks prescription status dropdown")
    public void doctor_clicks_prescription_status_dropdown(){
        waitAndClick(prescriptionsPages.statusDropdown);
    }

    @And("doctor should see status dropdown options")
    public  void doctor_should_see_status_dropdown_options(){
        Assertions.assertTrue(prescriptionsPages.statusDropdown.isDisplayed());
    }

    @Then("doctor should see filtered prescriptions")
    public void doctor_should_see_filtered_prescriptions(){
        waitUntilVisible(10, prescriptionsPages.prescriptionTable);
        Assertions.assertTrue(prescriptionsPages.prescriptionTable.getText().contains("Active"));
    }

    @When("doctor clicks on new prescription button")
    public void doctor_clicks_on_new_prescription_button() {
        waitAndClick(prescriptionsPages.newPrescription);
    }

    @And("doctor selects patient name")
    public void doctor_selects_patient_name() {
        waitAndClick(prescriptionsPages.patientNameDropdown);
        waitAndClick(prescriptionsPages.firstPatientOption);
    }

    @And("doctor enters medication name {string}")
    public void doctor_enters_medication_name(String medication) {
        waitAndSendKeys(prescriptionsPages.medicationNameField, medication);
    }

    @And("doctor enters dosage {string}")
    public void doctor_enters_dosage(String dosage) {
        waitAndSendKeys(prescriptionsPages.dosageField, dosage);
    }

    @And("doctor selects frequency {string}")
    public void doctor_selects_frequency(String frequency) {

        waitAndClick(prescriptionsPages.frequencyDropdown);

        WebElement frequancyOption = Driver.getDriver().findElement(By.xpath(
                "//*[@role='option' and normalize-space()='" +frequency + "']"
        ));
        scrollIntoViewJS(frequancyOption);
        jsClick(frequancyOption);
    }
    @And("doctor enters duration {string}")
    public  void doctor_enters_duration(String duration){
        waitAndSendKeys(prescriptionsPages.durationDaysButton, duration);
    }

    @And("doctor enters instructions {string}")
    public void doctor_enters_instructions(String instructions) {
        waitAndSendKeys(prescriptionsPages.instructionField, instructions);
    }

    @And("doctor clicks create prescription button")
    public void doctor_clicks_create_prescription_button() {
        waitAndClick(prescriptionsPages.createPrescriptionButton);
    }

    @Then("doctor should return to prescriptions page")
    public void doctor_should_return_to_prescriptions_page() {
        Assertions.assertTrue(prescriptionsPages.prescriptionTable.isDisplayed());
    }











}
