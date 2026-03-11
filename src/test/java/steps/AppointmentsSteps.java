package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.attribute.AnnotationAppender;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AppointmentsPage;
import pages.CommonPages;
import pages.LoginPage;
import utils.BaseUI;
import utils.Driver;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class AppointmentsSteps extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    AppointmentsPage appointmentsPage = new AppointmentsPage();
    CommonPages commonPages = new CommonPages();
    Faker faker = new Faker();


    @When("doctor navigates to the appointment page")
    public void doctor_navigates_to_the_appointment_page() {
        waitUntilVisible(20, commonPages.appointments);
        waitAndClick(commonPages.appointments);
        Assertions.assertTrue(appointmentsPage.appointmentsSign.isDisplayed());
    }

    @When("clicks on the schedule appointment button")
    public void clicks_on_the_schedule_appointment_button() {
        waitAndClick(appointmentsPage.scheduleAppointmentButton);
    }

    @When("filling out the form")
    public void filling_out_the_form() throws InterruptedException {
        waitUntilVisible(40, appointmentsPage.patientDropDown);
        appointmentsPage.patientDropDown.click();
        appointmentsPage.getPatientByName("Anderson", "Lisa").click();

        appointmentsPage.providerDropDown.click();
        appointmentsPage.getProvider("Osei").click();


        appointmentsPage.dateField.click();
        String randomDate = new SimpleDateFormat("MM/dd/yyyy")
                .format(faker.date().future(30, TimeUnit.DAYS));
        appointmentsPage.dateField.sendKeys(randomDate);

        //appointmentsPage.startTimeField.click();
        Thread.sleep(2000);
        appointmentsPage.startTimeField.sendKeys("10:00");
        appointmentsPage.startTimeField.sendKeys(Keys.ARROW_UP);

        //appointmentsPage.startTimeField.click();
        appointmentsPage.endTimeField.sendKeys("12:00");
        appointmentsPage.endTimeField.sendKeys(Keys.ARROW_DOWN);
        appointmentsPage.endTimeField.click();
    }

    @When("clicks on the schedule button")
    public void clicks_on_the_schedule_button(){
        waitAndClick(appointmentsPage.scheduleButton);
    }

    @Then("doctor should see appointment scheduled")
    public void doctor_should_see_appointment_scheduled() throws InterruptedException {
        //Thread.sleep(2000);
        waitUntilVisible(appointmentsPage.appointmentScheduledSuccessfullyMessageBy);
        Assertions.assertTrue(appointmentsPage.appointmentScheduledSuccessfullyMessage.isDisplayed());
    }
}