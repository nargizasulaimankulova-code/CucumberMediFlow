package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;

import static io.cucumber.core.options.Constants.*;



@SelectClasspathResource("features") //path to feature file
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps, steps.api") //pass to the step definition
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html") //where to put report
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@createPatient")
//@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")


public class ApiCucumberRunner {

}
