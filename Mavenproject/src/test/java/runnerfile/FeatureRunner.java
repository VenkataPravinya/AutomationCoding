package runnerfile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/featurefile"},
        glue = {"stepdefinitionfile"},
        tags = "@Infosys",
        monochrome = true,
        plugin = {"pretty","html:test.output/report.html",
                "json:test.output/jsonReport.json",
                "junit:test.output/junitReport.xml"}

)
public class FeatureRunner {

}
