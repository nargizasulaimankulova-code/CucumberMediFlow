package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginSteps extends BaseUI {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user goes to sign in page")
    public void user_goes_to_sign_in_page() {

        driver.get(ConfigurationReader.getProperty("loginURL"));
    }

    @When("user enters credentials {string} and {string}")
    public void user_enters_credentials_and(String string, String string2) {
        String username = ConfigurationReader.getProperty(string);
        String password = ConfigurationReader.getProperty(string2);

        waitAndSendKeys(loginPage.email, username);
        waitAndSendKeys(loginPage.password, password);
        waitAndClick(loginPage.signInButton);

    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {

        waitAndSendKeys(loginPage.email,username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {

        waitAndSendKeys(loginPage.password,password);
    }

    @When("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() {

        waitAndClick(loginPage.signInButton);
    }

    @Then("verify user signed in successfully")
    public void verify_user_signed_in_successfully() {

        waitUntilVisible(20, dashboardPage.welcomeSign);
        Assertions.assertTrue(dashboardPage.welcomeSign.isDisplayed());
        waitAndClick(dashboardPage.logoutButton);
    }

    @Then("verify user failed to sign in")
    public void verify_user_failed_to_sign_in() throws InterruptedException {
        Thread.sleep(1000);
        Assertions.assertTrue(driver.getCurrentUrl().contains("/login"));

    }
}
