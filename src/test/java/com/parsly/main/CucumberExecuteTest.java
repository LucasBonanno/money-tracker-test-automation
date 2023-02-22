package com.parsly.main;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @CucumberExecuteTest = Main class, responsible for managing and
 * running the tests.
 * @RunWith = When a class is annotated with RunWith, JUnit will invoke the class
 * referenced to run the tests.
 * @Features = path of ".features" files.
 * @Glue = Path of step definition classes (steps). Note: if not
 * specified the folder, it searches the entire structure.
 * @DryRun = If "true", checks if all the steps defined in the features are
 * implemented.
 * @Plugin = Defines the various reports that will be generated.
 * @Tags = handle ".features" tags. Example to rotate a tag
 * specifies: tags = {"@tag"}. More than one tag: tags = {"@tag1","@tag2"}.
 * Do not run a specific tag: tags ={"~@tag"}
 */
@RunWith( Cucumber.class )
@CucumberOptions(
        features = "classpath:features",
        glue = {
                "com.parsly"
        },
        tags = "@RegressionTests",
        plugin = { "pretty", "html:evidences/pretty-cucumber-report.html" },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true

)
public class CucumberExecuteTest {

}
