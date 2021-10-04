package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/RedbusAutomation/Features/Redbus.feature", glue = "Testcases", dryRun = false, plugin = {
		"pretty", "html:Reports/HTMLReport.html", "json:Reports/Jsonreport.json",
		"junit:Reports/JUnitreport.junit" }, tags = "@TC_SEARCH_006")


public class TestRunner {

}


