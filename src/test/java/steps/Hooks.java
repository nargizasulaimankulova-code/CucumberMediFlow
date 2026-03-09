package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
