package pages;

import org.openqa.selenium.By;
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

    @FindBy(css = "button[data-testid='logout-button']")
    public WebElement logoutButton;


    public By chartSurface = By.xpath("//*[name()='svg' and contains(@class,'recharts-surface')]");
    public By chartTooltip = By.xpath("//*[contains(@class,'recharts-default-tooltip')]");
    public By chartLabel = By.xpath("//*[contains(@class,'recharts-tooltip-label')]");

    public By firstBar = By.xpath("(//*[name()='g' and contains(@class,'recharts-bar-rectangle')]//*[name()='path'])[1]");

    public By chartContainer = By.xpath("//*[contains(@class,'recharts-wrapper')]");

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    public WebElement patient;

    @FindBy(xpath = "//button[text()='Profile']")
    public WebElement patientProfileBtn;

    @FindBy(xpath = "//div[@data-testid='stat-active-patients']")
    public WebElement acticePatientsBar;

    @FindBy(xpath = "//p[text()='Active Patients']")
    public WebElement activePatientsBarText;
}
