package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/nande/eclipse-workspace/GoogleAPICucumberN/src/test/java/Features",
        glue = "StepDef",
        plugin={"json:target/Reports/CucumberReport.json.",
                "html:target/Reports/report1.html"}
)
public class RunnerClass {

}
