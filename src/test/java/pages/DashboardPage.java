package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class DashboardPage {

    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h1")
    public WebElement welcomeSign;

    @FindBy(xpath = "//h1[text()='Sarah']")
    public WebElement doctorsWelcomeSign;

    @FindBy(tagName = "table")
    public WebElement patientsTable;

    @FindBy(name = "Mon")
    public WebElement graphColumn;

    @FindBy(xpath = "//p[@class='recharts-tooltip-label']")
    public WebElement chartLabel;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement patient;

    @FindBy(xpath = "//button[text()='Profile']")
    public WebElement patientProfileBtn;
}
