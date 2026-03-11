package steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.SchedulePage;
import utils.BaseUI;

public class ScheduleSteps extends BaseUI {
        SchedulePage schedulePage = new SchedulePage();

        @When("user opens My Schedule page")
        public void user_opens_my_schedule_page() {
            waitUntilVisible(10, schedulePage.myScheduleTab);
            schedulePage.myScheduleTab.click();
            waitUntilVisible(10, schedulePage.myScheduleSign);
        }

        @Then("user should see My Schedule page elements")
        public void user_should_see_my_schedule_page_elements() {
            Assertions.assertTrue(schedulePage.myScheduleSign.isDisplayed());
            Assertions.assertTrue(schedulePage.todayDropdown.isDisplayed());
        }

        @When("user clicks Check In button")
        public void user_clicks_check_in_button() {
            schedulePage.clickCheckIn();
        }

        @Then("appointment status should change to Checked In")
        public void appointment_status_should_change_to_checked_in() {
            schedulePage.verifyCheckedInStatus();
        }

        @When("user clicks Complete button")
        public void user_clicks_complete_button() {
            schedulePage.clickComplete();
        }

        @Then("appointment status should change to Completed")
        public void appointment_status_should_change_to_completed() {
            waitUntilVisible(10,schedulePage.completedPatientCount);
            Assertions.assertTrue(schedulePage.completedPatientCount.isDisplayed());
        }
    }


