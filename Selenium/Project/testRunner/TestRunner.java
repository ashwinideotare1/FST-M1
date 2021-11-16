package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@applyJob",
    plugin = { "pretty" },
    monochrome = true,
    publish = true
)

public class TestRunner {

}
