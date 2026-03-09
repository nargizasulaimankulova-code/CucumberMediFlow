package runners;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regression")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/regression-report.html")

public class RegressionRunner {
}
