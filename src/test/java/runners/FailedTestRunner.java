package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectFile("target/rerun.txt")

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps,hooks")

public class FailedTestRunner {
}