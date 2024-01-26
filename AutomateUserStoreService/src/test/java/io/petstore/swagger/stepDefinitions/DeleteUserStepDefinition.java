package io.petstore.swagger.stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.pepstore.swagger.questions.ServerResponseCode;
import io.pepstore.swagger.tasks.DeleteUserTask;
import io.pepstore.swagger.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static io.pepstore.swagger.utils.Constants.URL_BASE_USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserStepDefinition {
    public static final String endPoint = URL_BASE_USER;
    Actor user = Actor.named("user");

    Map<String, String> data = Data.extractURL().get(0);

    @Before
    public void setUpBaseUrl(){
        user.whoCan(CallAnApi.at(endPoint));
    }
    @When("The user consumes the endpoint to delete the user")
    public void theUserConsumesTheEndpointToDeleteTheUser() {
        user.attemptsTo(
                DeleteUserTask.delete()
        );

    }
    @Then("The user validates the response received from the server")
    public void theUserValidatesTheResponseReceivedFromTheServer() {
        user.should(
                seeThat(
                        "The response code is",
                        ServerResponseCode.was(),
                        equalTo(Integer.parseInt(data.get("StatusCode"))))
        );

    }
}

