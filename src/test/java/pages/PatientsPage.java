package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.List;

import static utils.Driver.driver;

public class PatientsPage {
    public PatientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(tagName = "h1")
    public WebElement mediFlowSign;

    @FindBy(xpath = "//tbody[@class='[&_tr:last-child]:border-0']//tr/td[2]")
    public List<WebElement> listOfPatients;

    @FindBy (css = "input[data-testid='patients-search']")
    public WebElement searchPatientInput;

    @FindBy (css = "button[data-testid^='view-patient']")
    public WebElement viewBtn;

    @FindBy(xpath = "//h1[@data-testid='patient-name']")
    public WebElement patentName;

    @FindBy(xpath = "//button[text()=' Edit Profile']")
    public WebElement editBtn;

    @FindBy(id = "edit_phone")
    public WebElement phoneNumber;

    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[text()='Patient updated successfully']")
    public WebElement successAlert;

    public void clickFirstViewPatient(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> buttons = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.cssSelector("button[data-testid*='view-patient']")
                )
        );

        buttons.get(0).click();
    }


}
