package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class PatientsPage {
    public PatientsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "input[data-testid='patients-search']")
    public WebElement searchPatientInput;



}
