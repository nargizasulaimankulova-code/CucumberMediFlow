package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class PrescriptionsPages {

    public PrescriptionsPages(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//a[@data-testid='nav-prescriptions']")
    public WebElement prescriptionTab;

    @FindBy(xpath = "//input[@data-testid='rx-search']")
    public WebElement searchBar;

    @FindBy(xpath = "//button [@data-testid='filter-rx-status']")
    public WebElement statusDropdown;

    @FindBy(xpath = "//button[@data-testid='create-prescription-btn']")
    public  WebElement newPrescription;

    @FindBy(xpath = "//button[.//span[text()='Select patient']]")
    public WebElement patientNameDropdown;

    @FindBy(xpath = "(//*[@role='option'])[1]")
    public  WebElement firstPatientOption;

    @FindBy(xpath = "//label[text()='Medication Name *']/following::input[1]")
    public WebElement medicationNameField;

    @FindBy(xpath = "//label[text()='Dosage *']/following::input[1]")
    public WebElement dosageField;

    @FindBy(xpath = "//label[contains(text(),'Frequency *')]/following::button[1]")
    public WebElement frequencyDropdown;

    @FindBy(xpath = "//label[contains(text(),'Frequency *')]/following::input[1]")
    public WebElement durationDaysButton;

    @FindBy(xpath = "//label[text()='Instructions']/following::textarea[1]")
    public  WebElement instructionField;

    @FindBy(xpath = "//button[text()='Create Prescription']")
    public WebElement createPrescriptionButton;

    @FindBy(xpath = "//table")
    public WebElement prescriptionTable;






}
