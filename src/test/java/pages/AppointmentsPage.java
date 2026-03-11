package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class AppointmentsPage {

    public AppointmentsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h1[text()='Appointments']")
    public WebElement appointmentsSign;

    @FindBy(xpath = "//button[@data-testid='schedule-appointment-btn']")
    public WebElement scheduleAppointmentButton;

    @FindBy(xpath = "//label[text()='Patient *']/following::button[@role='combobox'][1]")
    public WebElement patientDropDown;

    public WebElement getPatientByName(String firstName, String lastName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        By patientLocator = By.xpath(
                "//div[@role='option' and contains(.,'" + firstName + "') and contains(.,'" + lastName + "')]"
        );
        return wait.until(ExpectedConditions.visibilityOfElementLocated(patientLocator));
    }

    public WebElement getProvider(String provider) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        By providerLocator = By.xpath(
                "//div[@role='option' and contains(.,'" + provider + "')]"
        );
        return wait.until(ExpectedConditions.visibilityOfElementLocated(providerLocator));
    }

    @FindBy(xpath = "//label[text()='Provider *']/following::button[@role='combobox'][1]")
    public WebElement providerDropDown;


    @FindBy(xpath = "//label[normalize-space()='Date *']/parent::div/input")
    public WebElement dateField;

    @FindBy(xpath = "//label[text()='Start Time *']/following::input[@type='time'][1]")
    public WebElement startTimeField;

    @FindBy(xpath = "//label[text()='Start Time *']/following::input[@type='time'][2]")
    public WebElement endTimeField;

    @FindBy(xpath = "//button[text()='Schedule']")
    public WebElement scheduleButton;

    @FindBy(xpath = "//div[contains(text(),'Appointment scheduled successfully')]")
    public WebElement appointmentScheduledSuccessfullyMessage;

    public By appointmentScheduledSuccessfullyMessageBy = By.xpath("//li[@role='status']//*[contains(.,'Appointment scheduled successfully')]");
}
