package Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/RedbusAutomation/Features", 
glue = "RedbusAutomation.stepDefinition", 
dryRun = true,
plugin = {"html:Reports/HTMLReport.html", "json:Reports/Jsonreport.json", "junit:Reports/JUnitreport.junit" },
tags = "@round")

public class TestRunner {

}
