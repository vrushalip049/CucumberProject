

import org.junit.runner.RunWith;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "classpath:feature",
    glue = "StepDefinition",
    plugin = {"pretty", "json:target/cucumber.json"}
  //  tags = "@SmokeTest"
   // plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
	
}