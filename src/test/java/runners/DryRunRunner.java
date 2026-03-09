package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "true")

public class DryRunRunner {

}
                    //This runner:
                    //✔ checks step definitions
                    //❌ does NOT open browser