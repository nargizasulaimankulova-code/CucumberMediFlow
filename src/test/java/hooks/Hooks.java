package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.Driver;

import java.io.File;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(){
        //Driver.closeDriver();
        Driver.quitDriver();
    }

    @After
    public void takeScreenshotOnFailure(Scenario scenario) {

        if (scenario.isFailed()) {
            try {
                WebDriver driver = Driver.getDriver();

                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src,
                        new File("target/screenshots/" + scenario.getName() + ".png"));

            } catch (Exception e) {
                System.out.println("Screenshot failed: " + e.getMessage());
            }
        }
    }
}
