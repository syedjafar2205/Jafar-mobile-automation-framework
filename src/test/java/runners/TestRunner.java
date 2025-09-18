package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefs"},
    plugin = {
        "pretty",  
        "html:target/cucumber-html-report.html",   // Basic Cucumber HTML report
        "json:target/cucumber.json",               // JSON file for advanced reports
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure report
    },
    monochrome = true
)
public class TestRunner {
}
