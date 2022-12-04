package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

@RunWith(io.cucumber.junit.Cucumber.class)
@CucumberOptions(features = "Features", glue = { "stepDefinition" }, plugin = { "pretty",
		"html:target/cucumber.html" }, monochrome = true)
public class TestRunner {

}
