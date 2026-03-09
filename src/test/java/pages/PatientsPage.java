package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

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

    @FindBy (xpath = "//button[text()='View']")
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


}
