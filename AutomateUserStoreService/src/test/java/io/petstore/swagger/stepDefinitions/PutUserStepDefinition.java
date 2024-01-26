package io.petstore.swagger.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.pepstore.swagger.questions.ServerResponseCode;
import io.pepstore.swagger.tasks.PutUserTask;
import io.pepstore.swagger.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static io.pepstore.swagger.utils.Constants.URL_BASE_USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class PutUserStepDefinition {
    public static final String endPoint = URL_BASE_USER;
    Actor user = Actor.named("user");
    Map<String, String> data = Data.extractURL().get(0);

    @Before
    public void setUpBaseUrl(){
        user.whoCan(CallAnApi.at(endPoint));
    }
    @When("The user updates the basic data")
    public void theUserUpdatesTheBasicData() {
        user.attemptsTo(
                PutUserTask.put()
        );
    }
    @Then("The user can then validate if the update was successful with the response service")
    public void theUserCanThenValidateIfTheUpdateWasSuccessfulWithTheResponseService() {
        user.should(
                seeThat(
                        "The response code is",
                        ServerResponseCode.was(),
                        equalTo(Integer.parseInt(data.get("StatusCode"))))
        );
    }
}
