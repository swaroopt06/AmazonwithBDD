package runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
	    features = "src/test/resources/features",
	    glue = "stepdefinitions",
	    tags = "@test1",
	    plugin = {"pretty", "html:target/cucumber-Report.html"}
	)
public class TestRunner extends AbstractTestNGCucumberTests {

}
