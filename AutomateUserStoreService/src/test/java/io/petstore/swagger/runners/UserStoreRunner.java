package io.petstore.swagger.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "io.petstore.swagger.stepDefinitions",
        tags = "@PostUser",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class UserStoreRunner {
}
