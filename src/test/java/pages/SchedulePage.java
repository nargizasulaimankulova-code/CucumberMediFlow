package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SchedulePage {

        public SchedulePage() {
            PageFactory.initElements(Driver.getDriver(), this);

        }

    @FindBy(xpath = "//*[normalize-space()='My Schedule']")
    public WebElement myScheduleTab;

        @FindBy(xpath = "//h1[normalize-space()='My Schedule']")
        public WebElement myScheduleSign;

        @FindBy(xpath = "//span[text()='Today']")
        public WebElement todayDropdown;

        @FindBy(xpath = "//span[text()='This Week']")
        public WebElement thisWeekDropdown;

        @FindBy(xpath = "//p[normalize-space()='Checked In']/preceding-sibling::p")
        public WebElement checkedInPatientsCount;


        @FindBy(xpath = "//p[normalize-space()='Total']/preceding-sibling::p")
        public WebElement totalPatientsCount;


        @FindBy(xpath = "//p[normalize-space()='Scheduled']/preceding-sibling::p")
        public WebElement scheduledPatientCount;

        @FindBy(xpath = "//p[normalize-space()='Completed']/preceding-sibling::p")
        public WebElement completedPatientCount;

        @FindBy(xpath = "//button[contains(text(), 'Check In')]")
        public WebElement checkInBtn;

        @FindBy(xpath = "//div[contains(text(), 'CheckedIn')]")
        public WebElement checkedInBadge;

        @FindBy(xpath = "//button[contains(text(), 'Complete')]")
        public WebElement completeBtn;

        public void clickCheckIn() {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(checkInBtn));
            Assertions.assertTrue(checkInBtn.isDisplayed());
            checkInBtn.click();
        }

        public void verifyCheckedInStatus() {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(checkedInBadge));
            Assertions.assertEquals(checkedInBadge.getText(), "CheckedIn");
        }

        public void clickComplete() {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(completeBtn));
            Assertions.assertTrue(completeBtn.isEnabled());
            completeBtn.click();
        }
    }







