


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\Admin\\2025_eclipse-Automationworkspace\\CucumberProject\\src\\test\\resources\\feature\\Registration.feature",
    glue = "StepDefinition"
  //  tags = "@SmokeTest"
   // plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner {
}