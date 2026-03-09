package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CommonPages {
    WebDriver driver = Driver.getDriver();

    public CommonPages(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "My Schedule")
    public WebElement mySchedulePage;

    @FindBy(linkText = "Patients")
    public WebElement patients;

    @FindBy(linkText = "Appointments")
    public WebElement appointments;

    @FindBy(linkText = "Prescriptions")
    public WebElement prescriptions;
}
