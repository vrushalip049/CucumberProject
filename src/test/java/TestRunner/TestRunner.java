package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\Admin\\2025_eclipse-Automationworkspace\\CucumberProject\\src\\test\\resources\\feature\\RegistrationFeature.feature"
		,glue={"StepDefinition"},
		dryRun=false
		)

public class TestRunner {

}