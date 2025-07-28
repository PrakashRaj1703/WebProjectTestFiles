package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/test.feature",
glue = {"org.stepdefinition","hooks"},
monochrome = true, 
dryRun = false,
		snippets = io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE, 
		publish = true, 
	tags = "@test and not @dropDown",
		plugin = { "pretty","html:target/cucumber-repo.html", 
				"json:target/Json-repo.json",
				"rerun:target/failed.text"})

public class TestRunner {
	@AfterClass
	public static void generateJvmReport() {
		JVM.generate("target/Json-repo.json");
	}
	

}
