

import org.junit.runner.RunWith;

import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Admin\\2025_eclipse-Automationworkspace\\CucumberProject\\src\\test\\resources\\feature\\Registration.feature",
    glue = "StepDefinition",
    plugin = {"pretty", "json:target/cucumber.json"}
  //  tags = "@SmokeTest"
   // plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
	  public static void main(String[] args) {
	        Main.main(new String[]{
	            "--glue", "com.yourpackage.stepdefinitions",
	            "classpath:features"
	        });
	    }
}